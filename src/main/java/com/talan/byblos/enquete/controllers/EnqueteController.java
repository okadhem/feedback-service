package com.talan.byblos.enquete.controllers;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;


import com.talan.byblos.common.dto.PersonneDTO;
import com.talan.byblos.common.entities.EmployeeEntity;
import com.talan.byblos.common.utility.exception.ByblosDataAccessException;
import com.talan.byblos.common.utility.exception.ByblosSecurityException;
import com.talan.byblos.enquete.dao.SurveyDAO;
import com.talan.byblos.enquete.dao.SurveyResponseDAO;
import com.talan.byblos.enquete.dao.QMultChoicesDAO;
import com.talan.byblos.enquete.dao.QTextDAO;
import com.talan.byblos.enquete.dao.QuestionDAO;
import com.talan.byblos.enquete.dao.ResponseDAO;
import com.talan.byblos.enquete.dto.QuestionDTO;
import com.talan.byblos.enquete.dto.ResponseDTO;
import com.talan.byblos.enquete.dto.ResponseMultValuesDTO;
import com.talan.byblos.enquete.dto.ResultReportDTO;
import com.talan.byblos.enquete.dto.SurveyDTO;
import com.talan.byblos.enquete.dto.SurveyResponseDTO;
import com.talan.byblos.enquete.entites.ResponseEntity;
import com.talan.byblos.enquete.exceptions.SurveyExeption;
import com.talan.byblos.feedback.utility.mapping.PersonneUtility;


@RestController
@RequestMapping("api")
@CrossOrigin("*")


public class EnqueteController {
	
	
	@PersistenceContext
	private EntityManager entityManager;
	@Autowired
	SurveyDAO surveyDAO;
	@Autowired
	QuestionDAO questionDAO;
	@Autowired
	QTextDAO qTextDAO;

	
	@Autowired
	ResponseDAO responseDAO;

	@Autowired
	SurveyResponseDAO surveyResponseDAO;
	

	
	
	@Autowired
	QuestionDAO qDAO;
	
	
	
	
	
	@Transactional(propagation= Propagation.REQUIRED, readOnly= false, noRollbackFor = Exception.class)
	@GetMapping("surveys/{id}")
	public SurveyDTO enqueteById(
			@PathVariable("id") long id,
			@RequestParam(name="connected-user") long userId) throws ByblosDataAccessException, ByblosSecurityException, SurveyExeption{
		
		SurveyDTO survey = surveyDAO.findById(id);
		
		
		PersonneDTO employee = userIdToEmployee(userId);
		
		
		if(!isEmployeeAuthorized(survey,employee))
		{
			throw new SurveyExeption(String.format("you are trying to access a survey that you do not have access to (survey id is %d)."
					, survey.getId()));
			// return an error	
		}
		
		
		
		return survey;
		
	
	}
	
	
	
	
	@Transactional(propagation= Propagation.REQUIRED, readOnly= false, noRollbackFor = Exception.class)
	@GetMapping("surveys")
	public List<SurveyDTO> enquetes(@RequestParam(name="connected-user") long userId) throws ByblosDataAccessException, ByblosSecurityException{
		
		PersonneDTO employee = userIdToEmployee(userId);
		
		List<SurveyDTO> surveys = surveyDAO.findAll().stream()
		.filter(s -> s.getExpirationDate().after(new Date()))
		.filter(s -> isEmployeeAuthorized(s,employee))
		.collect(Collectors.toList());
		
		return surveys;
		
	
	}
	
	
	
	

	@Transactional(propagation= Propagation.REQUIRED, readOnly= false, noRollbackFor = Exception.class)
	@PostMapping("surveys") 
	public SurveyDTO enquetes(
			@Valid @RequestBody SurveyDTO enquete,
			@RequestParam(name="connected-user") long userId) throws ByblosDataAccessException
	{
		
		PersonneDTO employee = userIdToEmployee(userId);
		enquete.setOwner(employee);
		
		
		return surveyDAO.merge(enquete);
		
	}
	
	
	
		
	@Transactional(noRollbackFor = Exception.class) 
	@PostMapping("surveys/{id}/responses")
	public SurveyResponseDTO postSurveyResponse(
				@Valid @RequestBody SurveyResponseDTO response,
				@RequestParam(name="connected-user") long userId,
				@PathVariable(name="id") long surveyId) throws ByblosDataAccessException, SurveyExeption
	{
		SurveyDTO survey = surveyDAO.findById(surveyId);
		PersonneDTO employee = userIdToEmployee(userId);
		
		
		
		if(survey.getExpirationDate().before(new Date())) {
			
			throw new SurveyExeption("error : survey " + surveyId +  " expired ! ");
		}
		
		
		if(!isEmployeeAuthorized(survey, employee))
		{
			// error you can't access this survey
			throw new SurveyExeption(String.format("you are trying to post a survey response to a survey that you do not have access to (survey id is %d)"
					, survey.getId()));
			
			
		}
		
		List<Long> questions = survey.getQuestions().stream().map(QuestionDTO::getId).collect(Collectors.toList());
		
		List<Long> requiredQuestions = survey.getQuestions().stream()
				.filter(QuestionDTO::isRequired)
				.map(QuestionDTO::getId)
				.collect(Collectors.toList());
		
		List<Long> answeredQuestions = response.getResponses().stream().map(ResponseDTO::getQuestionId).collect(Collectors.toList());

		
		if(!questions.containsAll(answeredQuestions)) {
			
			// a response does not belong to a question of this survey
			
			throw new SurveyExeption("a response does not relate to any question of this survey ! ");
		}
		
		if(!answeredQuestions.containsAll(requiredQuestions))
		{
			// a required question was not answered
			
			throw new SurveyExeption("a required question was not answered ! ");
			
			
		}
			
		
		
		
		
		
		response.setOwner(employee);
		response.setSurveyId(surveyId);
		
	
		return surveyResponseDAO.merge(response);
		
	}
	
	
	
	
	
	
	@Transactional(noRollbackFor = Exception.class)
	@GetMapping("surveys/{id}/responses") 
	public List<SurveyResponseDTO> getSurveyResponses( 
				@RequestParam(name="connected-user") long userId,
				@PathVariable(name="id") long surveyId) throws ByblosDataAccessException, ByblosSecurityException, SurveyExeption
	{
		PersonneDTO employee = userIdToEmployee(userId);
		
		SurveyDTO survey = surveyDAO.findById(surveyId);
		if(employee.getId() != survey.getOwner().getId())
		{
			// error you are not the owner of this survey
			throw new SurveyExeption(String.format("you are trying to access a survey responses (survey id is %d) that you do not own"
					, survey.getId()));
			
		}
		
		
		
			
		return surveyResponseDAO.findAll().stream()
				.filter(resp -> resp.getSurveyId() == surveyId)
				.collect(Collectors.toList());
		
	}
	
	
	

	
	
	
	
	
	@Transactional(noRollbackFor = Exception.class) 
	@GetMapping("surveys/{id}/my-response")
	public SurveyResponseDTO getSurveyUserSingleResponse(
				@RequestParam(name="connected-user") long userId,
				@PathVariable(name="id") long surveyId) throws ByblosDataAccessException, ByblosSecurityException, SurveyExeption
	{
		PersonneDTO employee = userIdToEmployee(userId);
		SurveyDTO survey = surveyDAO.findById(surveyId);
		
		if(!isEmployeeAuthorized(survey,employee))
		{
			throw new SurveyExeption(String.format("you are trying to get a survey response to a survey that you do not have access to (survey id is %d)"
					, survey.getId()));
			
		}
		
		
		Optional<SurveyResponseDTO> surveyResponse = surveyResponseDAO.findAll().stream()
		.filter(resp -> resp.getOwner().getId() == employee.getId())
		.filter(resp -> resp.getSurveyId() == surveyId)
		.findFirst();
		
		
		SurveyResponseDTO empty = new SurveyResponseDTO();
		
		empty.setOwner(employee);
		empty.setSurveyId(surveyId);
		
		
		return  surveyResponse.orElse(empty);
		
	}
	
	@Transactional(noRollbackFor = Exception.class)
	@GetMapping("employees") 
	public List<PersonneDTO> getEmployeeList() throws ByblosDataAccessException, ByblosSecurityException
	{
		return entityManager.createQuery("select e from EmployeeEntity e",EmployeeEntity.class)
				.getResultList().stream().map(PersonneUtility::convertEntityToDto)
				.collect(Collectors.toList());
		 
	
	}
	
	
	
	

	@Transactional(noRollbackFor = Exception.class) 
	@GetMapping("surveys/{id}/report")
	public List<ResultReportDTO> getSurveyReport(
				@RequestParam(name="connected-user") long userId,
				@PathVariable(name="id") long surveyId) throws ByblosDataAccessException, ByblosSecurityException, SurveyExeption
	{
		SurveyDTO survey = surveyDAO.findById(surveyId);
			
		
		
		return survey.getQuestions().stream().map(q -> {
			try {
				return q.reportResults(qDAO);
			} catch (SurveyExeption e) {
				
				e.printStackTrace();
			}
			return null;
		}).collect(Collectors.toList());
		

		
	}
	
	
	
	// checks if the connected user is authorized to view report / responses of a survey
	@GetMapping("surveys/{id}/isAuthorized")
	public boolean isConnectedUserTheOwner(
				@RequestParam(name="connected-user") long userId,
				@PathVariable(name="id") long surveyId) throws ByblosDataAccessException, ByblosSecurityException, SurveyExeption
	{
		PersonneDTO employee = userIdToEmployee(userId);
		SurveyDTO survey = surveyDAO.findById(surveyId);
		
		return survey.getOwner().getId() == employee.getId();
		
	
	}
	
	
	
	
	
	
	
	// this function checks if an Employee is authorized to access (see or answer) the survey

	private boolean isEmployeeAuthorized(SurveyDTO s, PersonneDTO employee) {
		
		
		if(s.getOwner().getId() == employee.getId())
			return true;
		
		// an empty visibility field represents a survey visible to everyone
		if(s.getVisibility().isEmpty())
			return true;
		
		if(s.getVisibility().stream().map(PersonneDTO::getId).anyMatch(id -> id == employee.getId()))
			return true;
		
		return false;
	}

	
	private PersonneDTO userIdToEmployee(long id) {
		
		TypedQuery<EmployeeEntity> query = entityManager
				.createQuery("select e from UserEntity u join u.personnel e where u.id =" + id, EmployeeEntity.class);
		
		return PersonneUtility.convertEntityToDto(query.getSingleResult());
		
		
	}
	
	
	 @ExceptionHandler(SurveyExeption.class)
	 public org.springframework.http.ResponseEntity<Object> handleExeption(SurveyExeption ex, WebRequest request)
	 {
		 
	        
		 return new org.springframework.http.ResponseEntity<Object>(ex.getMessage(), HttpStatus.CONFLICT);
		 
		 
		 
	 }
	

	


}

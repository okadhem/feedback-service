package com.talan.byblos.enquete.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.talan.byblos.common.dto.PersonneDTO;
import com.talan.byblos.common.entities.EmployeeEntity;
import com.talan.byblos.common.utility.exception.ByblosDataAccessException;
import com.talan.byblos.common.utility.exception.ByblosSecurityException;
import com.talan.byblos.enquete.dao.SurveyDAO;
import com.talan.byblos.enquete.dao.SurveyResponseDAO;
import com.talan.byblos.enquete.dao.QTextDAO;
import com.talan.byblos.enquete.dao.QuestionDAO;
import com.talan.byblos.enquete.dao.ResponseDAO;
import com.talan.byblos.enquete.dto.SurveyDTO;
import com.talan.byblos.enquete.dto.SurveyResponseDTO;
import com.talan.byblos.feedback.utility.mapping.PersonneUtility;
import com.talan.byblos.enquete.dto.QuestionDTO;
import com.talan.byblos.enquete.dto.ResponseDTO;


@RestController
@RequestMapping("api")
@CrossOrigin("*")


public class EnqueteController {
	
	
	@PersistenceContext
	private EntityManager entityManager;
	@Autowired
	SurveyDAO enqueteDAO;
	@Autowired
	QuestionDAO questionDAO;
	@Autowired
	QTextDAO qTextDAO;

	
	@Autowired
	ResponseDAO responseDAO;

	@Autowired
	SurveyResponseDAO surveyResponseDAO;
	
	
	
	
	
	@Transactional(propagation= Propagation.REQUIRED, readOnly= false, noRollbackFor = Exception.class)
	@GetMapping("enquetes/{id}")
	public SurveyDTO enqueteById(@PathVariable("id") long id) throws ByblosDataAccessException, ByblosSecurityException{
		
		
		return enqueteDAO.findById(id);
		
	
	}
	
	@Transactional(propagation= Propagation.REQUIRED, readOnly= false, noRollbackFor = Exception.class)
	@GetMapping("enquetes")
	public List<SurveyDTO> enquetes() throws ByblosDataAccessException, ByblosSecurityException{
		
		
		return enqueteDAO.findAll();
		
	
	}
	
	
	@Transactional(propagation= Propagation.REQUIRED, readOnly= false, noRollbackFor = Exception.class)
	@PostMapping("enquetes")
	public SurveyDTO enquetes(@RequestBody SurveyDTO enquete) throws ByblosDataAccessException{
		
		return enqueteDAO.merge(enquete);
		
	}
	
	
	
	
	
		
	@Transactional(noRollbackFor = Exception.class)
	@PostMapping("questions")
	public QuestionDTO questions(@RequestBody QuestionDTO question) throws ByblosDataAccessException{
			
	
				
		return questionDAO.merge(question);
		
	}
	

	@Transactional(propagation= Propagation.REQUIRED, readOnly= false, noRollbackFor = Exception.class)
	@GetMapping("questions")
	public List<QuestionDTO> questions() throws ByblosDataAccessException, ByblosSecurityException{
		
		
		return questionDAO.findAll();
		
	}
	
	
	@Transactional(noRollbackFor = Exception.class)
	@PostMapping("responses")
	public ResponseDTO responses(@RequestBody ResponseDTO response) throws ByblosDataAccessException{
			
	
		return responseDAO.merge(response);
		
	}
	
	
	@Transactional(noRollbackFor = Exception.class)
	@GetMapping("responses")
	public List<ResponseDTO> responses() throws ByblosDataAccessException, ByblosSecurityException{
			
	
		return responseDAO.findAll();
		
	}
	
	@Transactional(noRollbackFor = Exception.class)
	@PostMapping("survey-responses")
	public SurveyResponseDTO surveyResponses(@RequestBody SurveyResponseDTO response) throws ByblosDataAccessException{
			
	
		return surveyResponseDAO.merge(response);
		
	}
	
	@Transactional(noRollbackFor = Exception.class)
	@PostMapping("surveys/{id}/responses")
	public SurveyResponseDTO postSurveyResponse(
				@RequestBody SurveyResponseDTO response,
				@RequestParam(name="connected-user") long userId,
				@PathVariable(name="id") long surveyId) throws ByblosDataAccessException
	{
		PersonneDTO employee = userIdToEmployee(userId);
		response.setOwner(employee);
		response.setSurveyId(surveyId);
		
	
		return surveyResponseDAO.merge(response);
		
	}
	
	private PersonneDTO userIdToEmployee(long id) {
		
		TypedQuery<EmployeeEntity> query = entityManager
				.createQuery("select e from UserEntity u join u.personnel e where u.id =" + id, EmployeeEntity.class);
		
		return PersonneUtility.convertEntityToDto(query.getSingleResult());
		
		
	}
	
	
	


}

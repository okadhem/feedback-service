package com.talan.byblos.enquete.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.talan.byblos.common.utility.exception.ByblosDataAccessException;
import com.talan.byblos.common.utility.exception.ByblosSecurityException;
import com.talan.byblos.enquete.dao.SurveyDAO;
import com.talan.byblos.enquete.dao.SurveyResponseDAO;
import com.talan.byblos.enquete.dao.QTextDAO;
import com.talan.byblos.enquete.dao.QuestionDAO;
import com.talan.byblos.enquete.dao.ResponseDAO;
import com.talan.byblos.enquete.dto.SurveyDTO;
import com.talan.byblos.enquete.dto.SurveyResponseDTO;
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
	
	
	


}

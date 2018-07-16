package com.talan.byblos.feedback.controllers;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.LogFactoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.talan.byblos.common.dto.EmployeeDTO;
import com.talan.byblos.common.dto.ReponseDTO;
import com.talan.byblos.common.dto.ReponseFeedbackDTO;
import com.talan.byblos.common.utility.exception.ByblosException;
import com.talan.byblos.common.utility.log.LogUtility;
import com.talan.byblos.feedback.service.ReponseService;
import com.talan.byblos.feedback.controllers.uri.ReponseControllerUriConstants;

@RestController
@RequestMapping("api")
@RefreshScope
@CrossOrigin("*")
public class ReponseControllers {

	/***
	 * Logger
	 */
	public static  final Logger logger= LoggerFactory.getLogger(ReponseControllers.class);
	
	/**
	 * Logger
	 */
	private static final Log LOG = LogFactoryImpl.getLog(ReponseControllers.class);  
	
	@Autowired
	ReponseService reponseService;
	
	@GetMapping(ReponseControllerUriConstants.LOAD_ALL_REPONSE)
	@ResponseBody
	public List<ReponseDTO> loadAllReponse(){
		List<ReponseDTO> reponseList= null;
		reponseList = reponseService.loadAllReponse();
		
		return reponseList;
	}
	
	@GetMapping(ReponseControllerUriConstants.LOAD_REPONSE_PAR_ID_FEEDBACK)
	@ResponseBody
	public List<ReponseDTO> loadReponseByIdFeedback(@PathVariable("id") Long id){
		List<ReponseDTO> reponseList= null;
		reponseList= reponseService.loadReponseByIdFeedback(id);
		return reponseList;
		
	}
	
	
	@GetMapping(ReponseControllerUriConstants.FEEDBACKS_AVEC_REPONSE)
	@ResponseBody
	public List<Long> feedbackAvecReponse(){
		List<Long> idFeedbackList;
		idFeedbackList = reponseService.feedbackAvecReponse();
		return idFeedbackList;
		
	}
	
	/**
	 * Add new response 
	 * @throws ByblosException 
	 */
	@PostMapping(ReponseControllerUriConstants.ADD_NEW_RESPONSE)
	@ResponseBody
	public ReponseDTO addReponse(@Valid @RequestBody ReponseDTO reponseDTO) throws ByblosException {
		
		
		return reponseService.addReponse(reponseDTO);
		
		
	}
	
	@GetMapping(ReponseControllerUriConstants.Load_Names)
	@ResponseBody
	public List<String> loadNames(){
		List<String> Names;
		Names = reponseService.loadEmployes();
		return Names;
		
	}
	
	@GetMapping(ReponseControllerUriConstants.Load_Employee_ByName)
	@ResponseBody
	public Long LoadEmpl(@PathVariable("name") String Name) throws ByblosException{
		Long dto;
		dto = reponseService.loadEmployeeByNameS(Name);
		return dto;
		
	}
	
	@RequestMapping("/FindIdByloginUser")
	public Long FindIdByloginUser( String login_user ) throws ByblosException
	{
	return reponseService.loadEmployeeByNameS(login_user); 

	}
	

@GetMapping(ReponseControllerUriConstants.LOAD_NBR_REP)
	@ResponseBody
	public List<ReponseFeedbackDTO> loadNbReponse1(){
		return reponseService.loadNbReponse1();
	}

@GetMapping(ReponseControllerUriConstants.FEEDBACKS_PUBLIC_AVEC_REPONSE)
@ResponseBody
public List<Long> feedbackPublicAvecReponse(){
	List<Long> idFeedbackList;
	idFeedbackList = reponseService.feedbackPublicAvecReponse();
	return idFeedbackList;
	
}

@GetMapping(ReponseControllerUriConstants.FEEDBACKS_AVEC_REPONSE_Personel)
@ResponseBody
public List<Long> feedbackAvecReponsePersonel(@PathVariable("id") Long id){
	List<Long> idFeedbackList;
	idFeedbackList = reponseService.feedbackAvecReponsePersonel(id);
	return idFeedbackList;
	
}



}



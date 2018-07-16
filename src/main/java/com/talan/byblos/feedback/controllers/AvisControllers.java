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

import com.talan.byblos.common.dto.AvisDTO;
import com.talan.byblos.common.utility.exception.ByblosException;
import com.talan.byblos.common.utility.log.LogUtility;
import com.talan.byblos.feedback.service.AvisService;
import com.talan.byblos.feedback.controllers.uri.*;

@RestController
@RequestMapping("api")
@RefreshScope
@CrossOrigin("*")
public class AvisControllers {

	/***
	 * Logger
	 */
	public static  final Logger logger= LoggerFactory.getLogger(FeedbackControllers.class);
	
	/**
	 * Logger
	 */
	private static final Log LOG = LogFactoryImpl.getLog(FeedbackControllers.class); 
	
	@Autowired
	AvisService avisService;
	
	/**
	 * Ajoute un avis
	 */
	@PostMapping(AvisControllerUriConstants.ADD_AVIS)
	@ResponseBody
	public AvisDTO addAvis(@Valid @RequestBody AvisDTO avisDTO) {
		AvisDTO addAvis = null;
		
		try {
			addAvis= avisService.ajouterAvis(avisDTO);
		} catch (ByblosException e) {
			LogUtility.logError(LOG, e);
		}
		return addAvis;
	}
	
	/**
	 * Afficher tout les avis
	 */
	
	@GetMapping(AvisControllerUriConstants.LOAD_ALL_AVIS)
	@ResponseBody
	public List<AvisDTO> loadAllAvis(){
		
		List<AvisDTO> avisList= null;
		avisList = avisService.loadAllAvis();
		return avisList;
	}
	
	
	@GetMapping(AvisControllerUriConstants.LOAD_AVIS_BY_ID_THEME)
@ResponseBody
public List<AvisDTO> loadAvisByIdTheme(@PathVariable("id") Long id){

List<AvisDTO> avisList= null;
avisList = avisService.loadAvisByIdTheme(id);
return avisList;

}

@GetMapping(AvisControllerUriConstants.LOAD_MOYENNE_BY_ID_THEME)
@ResponseBody
public List<Double> moyeneRateByIdTheme(@PathVariable("id") Long id ) {
return avisService.moyenneRate(id);
}


@GetMapping(AvisControllerUriConstants.LOAD_NB_PARTICIPANT)
@ResponseBody
public long NombreParticipants() {
return avisService.NombreParticipants();
}
	
	
	
}


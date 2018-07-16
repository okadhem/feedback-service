package com.talan.byblos.feedback.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.LogFactoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.talan.byblos.common.dto.AffectationReponseDTO;
import com.talan.byblos.common.dto.AvisDTO;
import com.talan.byblos.common.dto.FeedbackDTO;
import com.talan.byblos.common.utility.exception.ByblosDataAccessException;
import com.talan.byblos.common.utility.exception.ByblosException;
import com.talan.byblos.common.utility.log.LogUtility;
import com.talan.byblos.feedback.service.AffectationReponseService;
import com.talan.byblos.feedback.service.AvisService;
import com.talan.byblos.feedback.controllers.uri.FeedbackControllerUriConstants;
import com.talan.byblos.feedback.controllers.uri.ReponseControllerUriConstants;

@RestController
@RequestMapping("api")
@RefreshScope
@CrossOrigin("*")
public class AffectationReponseController {
	/***
	 * Logger
	 */
	public static final Logger logger = LoggerFactory.getLogger(AffectationReponseController.class);

	/**
	 * Logger
	 */
	private static final Log LOG = LogFactoryImpl.getLog(AffectationReponseController.class);

	@Autowired
	AffectationReponseService affectationReponseService;

	/**
	 * Ajoute un avis
	 */
	@PostMapping(ReponseControllerUriConstants.ADD_Affectation)
	@ResponseBody
	public AffectationReponseDTO addAvis(@Valid @RequestBody AffectationReponseDTO affectationReponseDTO) {
		AffectationReponseDTO add = new AffectationReponseDTO();

		try {
			add = affectationReponseService.ajouterAffectation(affectationReponseDTO);
		} catch (ByblosException e) {
			LogUtility.logError(LOG, e);
		}
		return add;
	}

	@GetMapping(ReponseControllerUriConstants.LOAD_Affectation_BY_Feedback)
	@ResponseBody
	public List<AffectationReponseDTO> getFeedbackById(@PathVariable("id") Long id) {

		List<AffectationReponseDTO> a = new ArrayList<AffectationReponseDTO>();
		a = affectationReponseService.loadAffectation(id);

		return a;

	}

	@GetMapping(ReponseControllerUriConstants.COUNT)
	@ResponseBody
	public long check(@PathVariable("id") Long feedback , @PathVariable("id1") Long employee ) {

		Long a ;
		a = affectationReponseService.CheckifExists(feedback, employee);

		return a;

	}
	
	
	@DeleteMapping(ReponseControllerUriConstants.DELETE_AFFECTATION)
	@ResponseBody
	public Boolean deleteAffectation(@PathVariable("id") Long id , @PathVariable("id2") Long id2 ) throws ByblosDataAccessException {
		affectationReponseService.deleteAffectation(id, id2);
		return true;
	}

	
}

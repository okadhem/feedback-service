package com.talan.byblos.feedback.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.talan.byblos.common.dto.FeedbackDTO;
import com.talan.byblos.common.utility.exception.ByblosDataAccessException;
import com.talan.byblos.common.utility.exception.ByblosException;
import com.talan.byblos.common.utility.log.LogUtility;
import com.talan.byblos.feedback.service.FeedBackService;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.talan.byblos.feedback.controllers.uri.FeedbackControllerUriConstants;

@RestController
@RequestMapping("api")
@RefreshScope
@CrossOrigin(origins="*")
public class FeedbackControllers {

	/***
	 * Logger
	 */
	public static final Logger logger = LoggerFactory.getLogger(FeedbackControllers.class);

	/**
	 * Logger
	 */
	private static final Log LOG = LogFactoryImpl.getLog(FeedbackControllers.class);

	@Autowired
	FeedBackService feedbackService;

	/**
	 * Afficher les feedback par Id
	 * 
	 * @param id
	 * @return
	 */

	@GetMapping(FeedbackControllerUriConstants.LOAD_FEEDBACK_BY_ID)
	@ResponseBody
	public FeedbackDTO getFeedbackById(@PathVariable("id") Long id) {

		FeedbackDTO feedback = null;

		try {
			feedback = feedbackService.loadFeedback(id);
		} catch (ByblosException e) {
			LogUtility.logError(LOG, e);

		}
		return feedback;

	}

	@PostMapping(FeedbackControllerUriConstants.ADD_FEEDBACK)
	@ResponseBody
	public FeedbackDTO addFeedback(@Valid @RequestBody FeedbackDTO feedbackDTO) {

		FeedbackDTO addFeedback = new FeedbackDTO();

		try {
			addFeedback = feedbackService.ajouterFeedack(feedbackDTO);

		} catch (ByblosException e) {
			LogUtility.logError(LOG, e);
		}

		return addFeedback;
	}

	@GetMapping(FeedbackControllerUriConstants.LOAD_FEEDBACK_BY_ID_CATEGORIE)
	@ResponseBody
	public List<FeedbackDTO> loadFeedbackByIdCategorie(@PathVariable("id") Long idCategorie) {

		List<FeedbackDTO> feedbackList = null;
		feedbackList = feedbackService.loadFeedbackByIdCategorie(idCategorie);
		return feedbackList;
	}

	@GetMapping(FeedbackControllerUriConstants.LOAD_FEEDBACK_PAR_MOT_CLES)
	@ResponseBody
	public List<FeedbackDTO> chercherFeedback(@PathVariable("mc") String mc) {
		List<FeedbackDTO> feedbackList = null;
		feedbackList = feedbackService.chercherFeedback("'%" + mc + "%'");
		return feedbackList;
	}

	@GetMapping(FeedbackControllerUriConstants.LOAD_FEEDBACK_BY_ID_USER)
	@ResponseBody
	public List<FeedbackDTO> loadFeedbackByIdUser(@PathVariable("id") Long idUser) {
		List<FeedbackDTO> feedbackList = null;
		feedbackList = feedbackService.loadFeedbackByIdUser(idUser);
		return feedbackList;
	}

	@GetMapping(FeedbackControllerUriConstants.LOAD_FEEDBACK_PUBLIC)
	@ResponseBody

	public List<FeedbackDTO> loadFeedbackPublique() {
		List<FeedbackDTO> feedbackList = null;
		feedbackList = feedbackService.loadFeedbackPublique();
		return feedbackList;
	}

	@GetMapping(FeedbackControllerUriConstants.NMBR_ANOMALIE)
	@ResponseBody
	public Long nmbrAnomalie(@PathVariable("idUser") Long idUser) {
		return feedbackService.nmbrAnomalieById(idUser);

	}

	@GetMapping(FeedbackControllerUriConstants.NMBR_PROPOSITION)
	@ResponseBody
	public Long nmbrprop(@PathVariable("idUser") Long idUser) {
		return feedbackService.nmbrPropositionById(idUser);
	}

	@GetMapping(FeedbackControllerUriConstants.NMBR_PROPOSITION_PUBLIQUE)
	@ResponseBody
	public Long nmbrPropsitionPublique() {
		return feedbackService.nmbrPropositionPublique();
	}

	@GetMapping(FeedbackControllerUriConstants.NMBR_ANOMALIE_PUBLIQUE)
	@ResponseBody
	public Long nmbrAnomaliePublique() {
		return feedbackService.nmbrAnomaliePublique();
	}

	@GetMapping(FeedbackControllerUriConstants.StatistiquePrososition)
	@ResponseBody
	public List<Long> StatProp() {
		List<Long> somme = new ArrayList<>();
		somme.add(feedbackService.nmbrProposition());
		somme.add(feedbackService.nmbrAnomalie());
		return somme;
	}
	
	@GetMapping(FeedbackControllerUriConstants.StatistiqueAnomalie)
	@ResponseBody
	public long StatAnomalie() {
		long somme = feedbackService.nmbrAnomalie();
		return somme;
	}
	
	@GetMapping(FeedbackControllerUriConstants.LOAD_FEEDBACK)
	@ResponseBody
	public List<FeedbackDTO> loadFeedbacks() throws ByblosException {
		List<FeedbackDTO> feedbackList = new ArrayList<>();
		feedbackList = feedbackService.loadFeedback();
		return feedbackList;
	}
	
	
	@GetMapping(FeedbackControllerUriConstants.LoadKey)
	@ResponseBody
	public List<String> GetKeyAnomalie() {
		List<String> key = new ArrayList<String>();
		key = feedbackService.getKey();
		return key;
	}
	@GetMapping(FeedbackControllerUriConstants.LoadKeyProposition)
	@ResponseBody
	public List<String> GetKeyProposition() {
		List<String> key = new ArrayList<String>();
		key = feedbackService.getKeyProp();
		return key;
	}
	@GetMapping(FeedbackControllerUriConstants.LoadValueAnomalie)
	@ResponseBody
	public List<Long> GetValueAnomalie() {
		List<Long> val = new ArrayList<Long>();
		val = feedbackService.getValue();
		return val;
	}
	@GetMapping(FeedbackControllerUriConstants.LoadValueProposition)
	@ResponseBody
	public List<Long> GetValueProposition() {
		List<Long> val = new ArrayList<Long>();
		val = feedbackService.getValueProposition();
		return val;
	}
	
	@PutMapping(FeedbackControllerUriConstants.LOAD_FEEDBACK_BY_ID_set)
	@ResponseBody
	public Boolean getFeedbackByIdSetVisiblility(@PathVariable("id") Long id) throws ByblosDataAccessException {

		feedbackService.LoadFeedbackByID(id);
		return true;

	}
	
	@PutMapping(FeedbackControllerUriConstants.SET_ETAT_FEEDBACK)
	@ResponseBody
	public Boolean setEtatFeedback(@PathVariable("id") Long id) throws ByblosDataAccessException {
		feedbackService.setEtatFeedback(id);
		return true;
}

	
	@PutMapping(FeedbackControllerUriConstants.SET_ETAT_FEEDBACK_PROPOSITION)
	@ResponseBody
	public Boolean setEtatFeedbackPropo(@PathVariable("id") Long id) throws ByblosDataAccessException {
		feedbackService.setEtatFeedbackProposition(id);
		return true;
}
	
	@PutMapping(FeedbackControllerUriConstants.SET_ETAT_FEEDBACK_PROPOSITION_Revoir)
	@ResponseBody
	public Boolean setEtatFeedbackPropoRevoir(@PathVariable("id") Long id) throws ByblosDataAccessException {
		feedbackService.setEtatFeedbackProposition2(id);
		return true;
}
	
	@PutMapping(FeedbackControllerUriConstants.SET_ETAT_FEEDBACK_ANOMALIE)
	@ResponseBody
	public Boolean setEtatFeedbackAnomalie(@PathVariable("id") Long id) throws ByblosDataAccessException {
		feedbackService.setEtatFeedbackAnomalie(id);
		return true;
}
	@PutMapping(FeedbackControllerUriConstants.SET_ETAT_FEEDBACK_ANOMALIE2)
	@ResponseBody
	public Boolean setEtatFeedbackAnomalie2(@PathVariable("id") Long id) throws ByblosDataAccessException {
		feedbackService.setEtatFeedbackAnomalie2(id);
		return true;
}
	@PutMapping(FeedbackControllerUriConstants.SET_ETAT_FEEDBACK_ANOMALIE_RESOLU)
	@ResponseBody
	public Boolean setEtatFeedbackAnomalieResolu(@PathVariable("id") Long id) throws ByblosDataAccessException {
		feedbackService.setEtatFeedbackAnomalieResolu(id);
		return true;
}
	
	@GetMapping(FeedbackControllerUriConstants.NB_FEEDBACK_TRAITE)
	@ResponseBody
	public long getNbFeedbackTraite() {
		long somme = feedbackService.nbFeedbacksTraite();
		return somme;
	}
	
	
}

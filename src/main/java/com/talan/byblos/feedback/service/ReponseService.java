package com.talan.byblos.feedback.service;

import java.util.List;

import com.talan.byblos.common.dto.EmployeeDTO;
import com.talan.byblos.common.dto.FeedbackDTO;
import com.talan.byblos.common.dto.ReponseDTO;
import com.talan.byblos.common.dto.ReponseFeedbackDTO;
import com.talan.byblos.common.utility.exception.ByblosException;

public interface ReponseService {
	Long loadEmployeeByNameS(String Name) throws ByblosException;

	/**
	 * Afficher tout les reponses
	 * 
	 * @return
	 */
	List<ReponseDTO> loadAllReponse();

	/**
	 * Affichr les reponse par id Feedbcak
	 */
	List<ReponseDTO> loadReponseByIdFeedback(Long id);

	/**
	 * les feedback qui ont des reponses
	 */
	List<Long> feedbackAvecReponse();

	/**
	 * Add new Reponse
	 */
	ReponseDTO addReponse(ReponseDTO reponseDTO) throws ByblosException;

	List<String> loadEmployes();
	
	

	List<ReponseFeedbackDTO> loadNbReponse1();
	
	List<Long> feedbackPublicAvecReponse();
	List<Long> feedbackAvecReponsePersonel(Long id);

}

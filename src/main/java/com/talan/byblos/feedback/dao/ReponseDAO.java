package com.talan.byblos.feedback.dao;
import java.util.List;

import com.talan.byblos.common.dao.generic.GenericDAO;
import com.talan.byblos.common.dto.EmployeeDTO;
import com.talan.byblos.common.dto.ReponseDTO;
import com.talan.byblos.common.dto.ReponseFeedbackDTO;
import com.talan.byblos.common.entities.ReponseEntity;
import com.talan.byblos.common.utility.exception.ByblosException;


public interface ReponseDAO extends GenericDAO<ReponseDTO, ReponseEntity> {
	
	/**
	 *Aficher tout les Reponses
	 * @return
	 */
	List<ReponseDTO> loadAllReponse();
	
	/**
	 * Afiche les reponse par id Feedback
	 */
	List<ReponseDTO> loadReponseByIdFeedback(Long id);
	
	/**
	 * Les feedback qui ont des reponses
	 */
	List<Long> feedbackAvecReponse();
	
	
 List<String> loadEmployeeNames();
 
 Long loadEmployeeByName(String Name) throws ByblosException;

  List<ReponseFeedbackDTO> loadNbReponse1();

  List<Long> feedbackPublicAvecReponse();
  List<Long> feedbackPersonelAvecReponse(Long id);

  
}


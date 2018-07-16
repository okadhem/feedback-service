package com.talan.byblos.feedback.utility.mapping;

import com.talan.byblos.common.dto.ReponseFeedbackDTO;
import com.talan.byblos.common.entities.ReponseEntity;

public class ReponseFeedbackUtility {

	/**
	 * Instantiates a new feedback utility
	 */
	protected ReponseFeedbackUtility() {
		
	}
	
	/**
	 * Convertir DTO en Entity
	 */
	public static ReponseEntity convertDtoToEntity(ReponseFeedbackDTO reponseDTO) {
//		
		ReponseEntity reponseEntity = new ReponseEntity();
//		
//		reponseEntity.setIdReponse(reponseDTO.getIdReponseFeedback());
//		reponseEntity.setFeedback(new FeedbackEntity(reponseDTO.getFeedbackDTO().getIdFeedback()));
//		
//		
		return reponseEntity;
		
		
	}
	
	public static ReponseFeedbackDTO convertEntityToDTO(ReponseEntity reponseEntity) {
		
		ReponseFeedbackDTO reponseDTO = new ReponseFeedbackDTO();
//		reponseDTO.setIdReponseFeedback(reponseEntity.getIdReponse());
//		if(reponseEntity.getFeedback()!=null) {
//			reponseDTO.setFeedbackDTO(FeedbackUtility.convertEntityToDto(reponseEntity.getFeedback()));
//		}
		
		return reponseDTO;
		
	}

}

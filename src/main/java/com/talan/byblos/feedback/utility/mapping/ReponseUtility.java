package com.talan.byblos.feedback.utility.mapping;
import com.talan.byblos.common.dto.ReponseDTO;
import com.talan.byblos.common.entities.EmployeeEntity;
import com.talan.byblos.common.entities.FeedbackEntity;
import com.talan.byblos.common.entities.ReponseEntity;


public class ReponseUtility {
	
	/**
	 * Instantiates a new feedback utility
	 */
	protected ReponseUtility() {
		
	}
	
	/**
	 * Convertir DTO en Entity
	 */
	public static ReponseEntity convertDtoToEntity(ReponseDTO reponseDTO) {
		
		ReponseEntity reponseEntity = new ReponseEntity();
		
		reponseEntity.setIdReponse(reponseDTO.getIdReponse());
		reponseEntity.setReponse(reponseDTO.getReponse());
		reponseEntity.setFeedback(new FeedbackEntity(reponseDTO.getFeedbackDTO().getIdFeedback()));
		
		
		reponseEntity.setPersonnel(new EmployeeEntity(reponseDTO.getEmploye().getId()));
		
		return reponseEntity;
		
		
	}
	
	public static ReponseDTO convertEntityToDTO(ReponseEntity reponseEntity) {
		
		ReponseDTO reponseDTO = new ReponseDTO();
		
		reponseDTO.setIdReponse(reponseEntity.getIdReponse());
		reponseDTO.setReponse(reponseEntity.getReponse());
		if(reponseEntity.getFeedback()!=null) {
			reponseDTO.setFeedbackDTO(FeedbackUtility.convertEntityToDto(reponseEntity.getFeedback()));
		}
		if(reponseEntity.getPersonnel()!=null) {
			reponseDTO.setEmploye(PersonneUtility.convertEntityToDto(reponseEntity.getPersonnel()));
		}
		
		return reponseDTO;
		
	}

}



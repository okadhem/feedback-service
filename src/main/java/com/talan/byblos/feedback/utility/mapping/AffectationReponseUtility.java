package com.talan.byblos.feedback.utility.mapping;

import com.talan.byblos.common.dto.AffectationReponseDTO;
import com.talan.byblos.common.entities.AffectationReponseEntity;
import com.talan.byblos.common.entities.EmployeeEntity;
import com.talan.byblos.common.entities.FeedbackEntity;

public class AffectationReponseUtility {
protected AffectationReponseUtility() {
		
	}
	public static AffectationReponseEntity convertDtoToEntity(AffectationReponseDTO affectationDTO) {
		AffectationReponseEntity affectationEntity= new AffectationReponseEntity();
		affectationEntity.setId(affectationDTO.getId());
		affectationEntity.setFeedback(new FeedbackEntity(affectationDTO.getFeedback().getIdFeedback()));
		affectationEntity.setEmployee(new EmployeeEntity(affectationDTO.getEmployee().getId()));
		return affectationEntity;
	}
	
	public static AffectationReponseDTO convertEntityToDto(AffectationReponseEntity affectationEntity) {
		
		AffectationReponseDTO affectationDTO = new AffectationReponseDTO();
		

		affectationDTO.setId(affectationEntity.getId());
		if(affectationEntity.getFeedback()!= null) {
			affectationDTO.setFeedback(FeedbackUtility.convertEntityToDto(affectationEntity.getFeedback()));
		}
		if(affectationEntity.getEmployee()!=null) {
			affectationDTO.setEmployee(PersonneUtility.convertEntityToDto(affectationEntity.getEmployee()));
		}
		
		return affectationDTO;
	}


	
	
	
	
}

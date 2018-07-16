package com.talan.byblos.feedback.utility.mapping;


import com.talan.byblos.common.dto.FeedbackDTO;
import com.talan.byblos.common.entities.CategorieEntity;
import com.talan.byblos.common.entities.EmployeeEntity;
import com.talan.byblos.common.entities.FeedbackEntity;


public class FeedbackUtility {

	/**
	 * Instantiates a new feedback utility
	 */
	protected FeedbackUtility() {

	}

	/**
	 * Convertir DTO en Entity
	 * 
	 * @param feedbackDTO
	 * @return
	 */

	public static FeedbackEntity convertDtoToEntity(FeedbackDTO feedbackDTO) {

		FeedbackEntity feedbackEntity = new FeedbackEntity();
		feedbackEntity.setId(feedbackDTO.getIdFeedback());
		feedbackEntity.setObjetFeedback(feedbackDTO.getObjetFeedback());
		feedbackEntity.setContenuFeedback(feedbackDTO.getContenuFeedback());
		feedbackEntity.setAnonymatFeedback(feedbackDTO.getAnonymatFeedback());
		feedbackEntity.setEtatFeedback(feedbackDTO.getEtatFeedback());
		feedbackEntity.setVisibiliteFeedback(feedbackDTO.getVisibiliteFeedback());
		feedbackEntity.setCategorie(new CategorieEntity(feedbackDTO.getCategorieDTO().getId()));
		feedbackEntity.setEmployee(	new EmployeeEntity(feedbackDTO.getEmployee().getId()));
		feedbackEntity.setCriticite(feedbackDTO.getCriticite());

		return feedbackEntity;

	}

	/**
	 * Convertir Entity en DTO
	 * 
	 * @param feedbackEntity
	 * @return
	 */

	public static FeedbackDTO convertEntityToDto(FeedbackEntity feedbackEntity) {

		FeedbackDTO feedbackDTO = new FeedbackDTO();

		feedbackDTO.setIdFeedback(feedbackEntity.getId());
		feedbackDTO.setObjetFeedback(feedbackEntity.getObjetFeedback());
		feedbackDTO.setContenuFeedback(feedbackEntity.getContenuFeedback());
		feedbackDTO.setAnonymatFeedback(feedbackEntity.getAnonymatFeedback());
		feedbackDTO.setEtatFeedback(feedbackEntity.getEtatFeedback());
		feedbackDTO.setVisibiliteFeedback(feedbackEntity.getVisibiliteFeedback());
		if(feedbackEntity.getCategorie()!=null) {
		feedbackDTO.setCategorieDTO(CategorieUtility.convertEntityToDto(feedbackEntity.getCategorie()));
		}
		if(feedbackEntity.getEmployee()!=null) {
		feedbackDTO.setEmployee(PersonneUtility.convertEntityToDto(feedbackEntity.getEmployee()));
		}
		feedbackDTO.setCriticite(feedbackEntity.getCriticite());
		return feedbackDTO;

	}
}

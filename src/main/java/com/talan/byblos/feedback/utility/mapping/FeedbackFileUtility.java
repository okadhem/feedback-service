package com.talan.byblos.feedback.utility.mapping;

import com.talan.byblos.common.dto.FeedbackFileDTO;
import com.talan.byblos.common.entities.FeedbackEntity;
import com.talan.byblos.common.entities.FeedbackFilesEntity;

public class FeedbackFileUtility {

	/**
	 * Instantiates a new FeedbackFile utility
	 */
	protected FeedbackFileUtility() {

	}

	public static FeedbackFilesEntity convertDtoToEntity(FeedbackFileDTO feedbackfileDTO) {

		FeedbackFilesEntity feedbackFilesEntity = new FeedbackFilesEntity();

		feedbackFilesEntity.setIdFile(feedbackfileDTO.getIdFile());
		feedbackFilesEntity.setPath(feedbackfileDTO.getPath());
		feedbackFilesEntity.setFileName(feedbackfileDTO.getFileName());
		feedbackFilesEntity.setFeedbackEntity(new FeedbackEntity(feedbackfileDTO.getFeedbackDTO().getIdFeedback()));

		return feedbackFilesEntity;
	}

	public static FeedbackFileDTO convertEntityToDto(FeedbackFilesEntity feedbackfileEntity) {

		FeedbackFileDTO feedbackFileDTO = new FeedbackFileDTO();

		feedbackFileDTO.setIdFile(feedbackfileEntity.getIdFile());
		feedbackFileDTO.setPath(feedbackfileEntity.getPath());
		feedbackFileDTO.setFileName(feedbackfileEntity.getFileName());
		feedbackFileDTO.setFeedbackDTO(FeedbackUtility.convertEntityToDto(feedbackfileEntity.getFeedbackEntity()));

		return feedbackFileDTO;

	}
}

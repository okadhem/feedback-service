package com.talan.byblos.enquete.dao.impl;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.talan.byblos.common.dao.impl.generic.GenericDAOImpl;
import com.talan.byblos.enquete.dao.SurveyResponseDAO;
import com.talan.byblos.enquete.dto.ResponseDTO;
import com.talan.byblos.enquete.dto.SurveyResponseDTO;
import com.talan.byblos.enquete.entites.ResponseEntity;
import com.talan.byblos.enquete.entites.SurveyEntity;
import com.talan.byblos.enquete.entites.SurveyResponseEntity;



@Component

public class SurveyResponseDAOImpl extends GenericDAOImpl<SurveyResponseDTO, SurveyResponseEntity> implements SurveyResponseDAO{

	@Override
	public SurveyResponseEntity getEntityFromDTO(SurveyResponseDTO dto) {
		SurveyResponseEntity entity = new SurveyResponseEntity();
		entity.setId(dto.getId());
		entity.setResponses(dto.getResponses().stream().map(ResponseDTO::toEntity).collect(Collectors.toList()));
		SurveyEntity survey = new SurveyEntity();
		survey.setId(dto.getSurveyId());
		entity.setSurvey(survey);
		// we still need to handel owner (maybe)
		
		return entity;
	}

	@Override
	public SurveyResponseDTO getDTOFromEntity(SurveyResponseEntity entity) {
		SurveyResponseDTO dto = new SurveyResponseDTO();
		dto.setId(entity.getId());
		dto.setResponses(entity.getResponses().stream().map(ResponseEntity::toDTO).collect(Collectors.toList()));
		dto.setSurveyId(entity.getSurvey().getId());
		
		
		// we still need to handel owner (maybe)
		return dto;
	}

}

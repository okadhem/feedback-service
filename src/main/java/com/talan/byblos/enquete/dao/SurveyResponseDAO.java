package com.talan.byblos.enquete.dao;

import org.springframework.stereotype.Component;

import com.talan.byblos.common.dao.generic.GenericDAO;
import com.talan.byblos.enquete.dto.SurveyDTO;
import com.talan.byblos.enquete.dto.SurveyResponseDTO;
import com.talan.byblos.enquete.entites.SurveyEntity;
import com.talan.byblos.enquete.entites.SurveyResponseEntity;

@Component
public interface SurveyResponseDAO extends GenericDAO<SurveyResponseDTO, SurveyResponseEntity>{
		
	public SurveyResponseDTO findById(long id);
}

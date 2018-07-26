package com.talan.byblos.enquete.dao;

import com.talan.byblos.common.dao.generic.GenericDAO;
import com.talan.byblos.enquete.dto.SurveyDTO;
import com.talan.byblos.enquete.entites.SurveyEntity;


public interface SurveyDAO extends GenericDAO<SurveyDTO, SurveyEntity> {
	public SurveyDTO findById(long id);

}

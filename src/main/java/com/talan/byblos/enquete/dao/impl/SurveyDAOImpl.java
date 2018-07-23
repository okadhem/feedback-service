package com.talan.byblos.enquete.dao.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.talan.byblos.common.dao.impl.generic.GenericDAOImpl;
import com.talan.byblos.common.utility.exception.ByblosDataAccessException;
import com.talan.byblos.common.utility.exception.ByblosSecurityException;
import com.talan.byblos.enquete.dao.SurveyDAO;
import com.talan.byblos.enquete.dto.SurveyDTO;
import com.talan.byblos.enquete.dto.QuestionDTO;
import com.talan.byblos.enquete.entites.SurveyEntity;
import com.talan.byblos.enquete.entites.QuestionEntity;


@Component

public class SurveyDAOImpl extends GenericDAOImpl<SurveyDTO, SurveyEntity> implements SurveyDAO{

	@Override
	public List<SurveyDTO> findAll() throws ByblosDataAccessException, ByblosSecurityException{
		String query = "select e from SurveyEntity e";
		List<SurveyEntity> queryResult = getEntityManager().createQuery(query).getResultList();
		
		
		return queryResult.stream().map(this::getDTOFromEntity).collect(Collectors.toList());
		
		
	}
	
	@Override
	public SurveyEntity getEntityFromDTO(SurveyDTO dto) {
	
		QuestionDAOImpl qDao = new QuestionDAOImpl(); 
		List<QuestionEntity> entityQuestions = dto.getQuestions().stream().map(qDao::getEntityFromDTO).collect(Collectors.toList());
		SurveyEntity e = new SurveyEntity();
		e.setQuestions(entityQuestions);
		e.setExpirationDate(dto.getExpirationDate());
		e.setName(dto.getName());
		e.setId(dto.getId());
		return e;
	
	
	}

	
	
	
	@Override
	public SurveyDTO getDTOFromEntity(SurveyEntity entity) {
		
		QuestionDAOImpl qDao = new QuestionDAOImpl(); 
		SurveyDTO dto = new SurveyDTO();
		List<QuestionDTO> DTOQuestions = entity.getQuestions().stream().map(qDao::getDTOFromEntity).collect(Collectors.toList());
		dto.setQuestions(DTOQuestions);
		dto.setExpirationDate(entity.getExpirationDate());
		dto.setName(entity.getName());
		dto.setId(entity.getId());
		
		
		return dto;
		
		
	}

}

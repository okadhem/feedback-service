package com.talan.byblos.enquete.dao.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.talan.byblos.common.dao.impl.generic.GenericDAOImpl;
import com.talan.byblos.common.utility.exception.ByblosDataAccessException;
import com.talan.byblos.common.utility.exception.ByblosSecurityException;
import com.talan.byblos.enquete.dao.EnqueteDAO;
import com.talan.byblos.enquete.dto.EnqueteDTO;
import com.talan.byblos.enquete.dto.QuestionDTO;
import com.talan.byblos.enquete.entites.EnqueteEntity;
import com.talan.byblos.enquete.entites.QuestionEntity;


@Component

public class EnqueteDAOImpl extends GenericDAOImpl<EnqueteDTO, EnqueteEntity> implements EnqueteDAO{

	@Override
	public List<EnqueteDTO> findAll() throws ByblosDataAccessException, ByblosSecurityException{
		String query = "select e from EnqueteEntity e";
		List<EnqueteEntity> queryResult = getEntityManager().createQuery(query).getResultList();
		
		
		return queryResult.stream().map(this::getDTOFromEntity).collect(Collectors.toList());
		
		
	}
	
	@Override
	public EnqueteEntity getEntityFromDTO(EnqueteDTO dto) {
	
		QuestionDAOImpl qDao = new QuestionDAOImpl(); 
		List<QuestionEntity> entityQuestions = dto.getQuestions().stream().map(qDao::getEntityFromDTO).collect(Collectors.toList());
		EnqueteEntity e = new EnqueteEntity();
		e.setQuestions(entityQuestions);
		e.setExpirationDate(dto.getExpirationDate());
		e.setName(dto.getName());
		e.setId(dto.getId());
		return e;
	
	
	}

	
	
	
	@Override
	public EnqueteDTO getDTOFromEntity(EnqueteEntity entity) {
		
		QuestionDAOImpl qDao = new QuestionDAOImpl(); 
		EnqueteDTO dto = new EnqueteDTO();
		List<QuestionDTO> DTOQuestions = entity.getQuestions().stream().map(qDao::getDTOFromEntity).collect(Collectors.toList());
		dto.setQuestions(DTOQuestions);
		dto.setExpirationDate(entity.getExpirationDate());
		dto.setName(entity.getName());
		dto.setId(entity.getId());
		
		
		return dto;
		
		
	}

}

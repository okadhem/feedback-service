package com.talan.byblos.enquete.dao.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import com.talan.byblos.common.dao.impl.generic.GenericDAOImpl;
import com.talan.byblos.common.dto.PersonneDTO;
import com.talan.byblos.enquete.dao.SurveyResponseDAO;
import com.talan.byblos.enquete.dto.ResponseDTO;
import com.talan.byblos.enquete.dto.SurveyResponseDTO;
import com.talan.byblos.enquete.entites.ResponseEntity;
import com.talan.byblos.enquete.entites.SurveyEntity;
import com.talan.byblos.enquete.entites.SurveyResponseEntity;
import com.talan.byblos.feedback.utility.mapping.PersonneUtility;



@Component

public class SurveyResponseDAOImpl extends GenericDAOImpl<SurveyResponseDTO, SurveyResponseEntity> implements SurveyResponseDAO{

	@PersistenceContext
	EntityManager em;
	
	
	@Override
	public SurveyResponseEntity getEntityFromDTO(SurveyResponseDTO dto) {
		SurveyResponseEntity entity = new SurveyResponseEntity();
		entity.setId(dto.getId());
		entity.setResponses(dto.getResponses().stream().map(ResponseDTO::toEntity).collect(Collectors.toList()));
		SurveyEntity survey = new SurveyEntity();
		survey.setId(dto.getSurveyId());
		entity.setSurvey(survey);
		entity.setOwner(PersonneUtility.convertDtoToEntity(dto.getOwner(), null));
		
		
		return entity;
	}

	@Override
	public SurveyResponseDTO getDTOFromEntity(SurveyResponseEntity entity) {
		SurveyResponseDTO dto = new SurveyResponseDTO();
		dto.setId(entity.getId());
		dto.setResponses(entity.getResponses().stream().map(ResponseEntity::toDTO).collect(Collectors.toList()));
		dto.setSurveyId(entity.getSurvey().getId());
			
		dto.setOwner(PersonneUtility.convertEntityToDto(entity.getOwner()));
		
		return dto;
	}
	
	@Override
	public SurveyResponseDTO findById(long id) {
		TypedQuery<SurveyResponseEntity> query = 
				em.createQuery("select r from SurveyResponseEntity r where r.id=" + id, SurveyResponseEntity.class);
		
		return getDTOFromEntity(query.getSingleResult());
		
	}
	
	@Override
	public List<SurveyResponseDTO> findAll() {
		TypedQuery<SurveyResponseEntity> query = 
				em.createQuery("select r from SurveyResponseEntity r", SurveyResponseEntity.class);
		
		return query.getResultList().stream().map(this::getDTOFromEntity).collect(Collectors.toList());
		
	}

}

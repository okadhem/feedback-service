package com.talan.byblos.enquete.dao.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import com.talan.byblos.common.dao.impl.generic.GenericDAOImpl;
import com.talan.byblos.common.dto.PersonneDTO;
import com.talan.byblos.common.entities.EmployeeEntity;
import com.talan.byblos.common.utility.exception.ByblosDataAccessException;
import com.talan.byblos.common.utility.exception.ByblosSecurityException;
import com.talan.byblos.enquete.dao.SurveyDAO;
import com.talan.byblos.enquete.dto.SurveyDTO;
import com.talan.byblos.enquete.dto.QuestionDTO;
import com.talan.byblos.enquete.entites.SurveyEntity;
import com.talan.byblos.enquete.entites.SurveyResponseEntity;
import com.talan.byblos.feedback.utility.mapping.PersonneUtility;
import com.talan.byblos.enquete.entites.QuestionEntity;


@Component

public class SurveyDAOImpl extends GenericDAOImpl<SurveyDTO, SurveyEntity> implements SurveyDAO{

	
	@PersistenceContext
	EntityManager em;

	
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
		e.setTitle(dto.getTitle());
		e.setId(dto.getId());
		e.setDescription(dto.getDescription());
		e.setOwner(PersonneUtility.convertDtoToEntity(dto.getOwner(), null));
		
		
		List<EmployeeEntity> visibility = dto.getVisibility().stream().map(personDTO -> {
			EmployeeEntity employeeEntity = new EmployeeEntity();
			 employeeEntity.setId(personDTO.getId());
			 employeeEntity.setFirstName(personDTO.getFirstName());
			 employeeEntity.setLastName(personDTO.getLastName());
			 return employeeEntity;
		}).collect(Collectors.toList());
		
		e.setVisibility(visibility);
		return e;
	
	
	}

	
	
	
	@Override
	public SurveyDTO getDTOFromEntity(SurveyEntity entity) {
		
		QuestionDAOImpl qDao = new QuestionDAOImpl(); 
		SurveyDTO dto = new SurveyDTO();
		List<QuestionDTO> DTOQuestions = entity.getQuestions().stream().map(qDao::getDTOFromEntity).collect(Collectors.toList());
		dto.setQuestions(DTOQuestions);
		dto.setExpirationDate(entity.getExpirationDate());
		dto.setTitle(entity.getTitle());
		dto.setId(entity.getId());
		dto.setDescription(entity.getDescription());
		dto.setOwner(PersonneUtility.convertEntityToDto(entity.getOwner()));
		
		List<PersonneDTO> visibility = entity.getVisibility().stream().map(personEntity -> {
			PersonneDTO personDTO = new PersonneDTO();
			personDTO.setId(personEntity.getId());
			personDTO.setFirstName(personEntity.getFirstName());
			personDTO.setLastName(personEntity.getLastName());
			return personDTO;
		}).collect(Collectors.toList());
		
		dto.setVisibility(visibility);
				
		
		return dto;
		
		
	}

	
	
	public SurveyDTO findById(long id) {
		TypedQuery<SurveyEntity> query = 
				em.createQuery("select s from SurveyEntity s where s.id=" + id, SurveyEntity.class);
		
		return getDTOFromEntity(query.getSingleResult());
		
	}
}

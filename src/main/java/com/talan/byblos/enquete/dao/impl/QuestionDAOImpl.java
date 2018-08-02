package com.talan.byblos.enquete.dao.impl;



import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import com.talan.byblos.common.dao.impl.generic.GenericDAOImpl;
import com.talan.byblos.common.utility.exception.ByblosDataAccessException;
import com.talan.byblos.common.utility.exception.ByblosSecurityException;
import com.talan.byblos.enquete.dao.QuestionDAO;
import com.talan.byblos.enquete.dto.QuestionDTO;
import com.talan.byblos.enquete.dto.ResponseDTO;
import com.talan.byblos.enquete.dto.ResponseMultValuesDTO;
import com.talan.byblos.enquete.entites.QuestionEntity;
import com.talan.byblos.enquete.entites.RMultValuesEntity;
import com.talan.byblos.enquete.entites.RSingleValueEntity;
import com.talan.byblos.enquete.entites.ResponseEntity;




@Component
public class QuestionDAOImpl extends GenericDAOImpl<QuestionDTO, QuestionEntity> implements QuestionDAO {

	
	@Override
	public List<QuestionDTO> findAll() throws ByblosDataAccessException, ByblosSecurityException {
		String query = "select q from QuestionEntity q";
		List<QuestionEntity> queryResult = getEntityManager().createQuery(query).getResultList();
		
		return queryResult.stream().map(this::getDTOFromEntity).collect(Collectors.toList());
		
	}

	
	@Override
	public QuestionEntity getEntityFromDTO(QuestionDTO dto) {
		
		return dto.toEntity();
		
	}

	@Override
	public QuestionDTO getDTOFromEntity(QuestionEntity entity) {
		return entity.toDTO();
	}
	
	@Override
	public List<ResponseDTO> findAllAnswersByQuestionId(long id) {
		
		List<ResponseDTO> res = getEntityManager().createQuery("select r from ResponseEntity r where r.question.id=" + id, ResponseEntity.class)
		.getResultList().stream().map(r -> r.toDTO())
		.collect(Collectors.toList());
		return res;
	}


	
}

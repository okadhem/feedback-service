package com.talan.byblos.enquete.dao.impl;


import java.util.List;

import java.util.stream.Collectors;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import com.talan.byblos.common.dao.impl.generic.GenericDAOImpl;

import com.talan.byblos.common.utility.exception.ByblosDataAccessException;
import com.talan.byblos.common.utility.exception.ByblosSecurityException;
import com.talan.byblos.enquete.dao.ResponseDAO;
import com.talan.byblos.enquete.dto.ResponseDTO;
import com.talan.byblos.enquete.entites.ResponseEntity;

@Component
public class ResponseDAOImpl  extends GenericDAOImpl<ResponseDTO, ResponseEntity> implements ResponseDAO {

	@Override
	public ResponseEntity getEntityFromDTO(ResponseDTO dto) {
		return dto.toEntity();
		
	}

	@Override
	public ResponseDTO getDTOFromEntity(ResponseEntity entity) {
		return entity.toDTO();
	}
	
	@Override
	public List<ResponseDTO> findAll() throws ByblosDataAccessException, ByblosSecurityException {
			TypedQuery<ResponseEntity> query = getEntityManager().
					createQuery("select r from ResponseEntity r",ResponseEntity.class );
			
			return query.getResultList().stream().map(this::getDTOFromEntity).collect(Collectors.toList());
			
	}

	

}

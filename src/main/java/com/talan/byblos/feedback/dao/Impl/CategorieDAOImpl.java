package com.talan.byblos.feedback.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.LogFactoryImpl;
import org.springframework.stereotype.Repository;

import com.talan.byblos.common.dao.impl.generic.GenericDAOImpl;
import com.talan.byblos.common.dto.CategorieDTO;
import com.talan.byblos.common.dto.FeedbackDTO;
import com.talan.byblos.common.entities.CategorieEntity;
import com.talan.byblos.common.entities.FeedbackEntity;
import com.talan.byblos.common.utility.exception.ByblosException;
import com.talan.byblos.feedback.dao.CategorieDAO;
import com.talan.byblos.feedback.utility.mapping.CategorieUtility;

@Repository("categorieDAO")
public class CategorieDAOImpl extends GenericDAOImpl<CategorieDTO, CategorieEntity> implements CategorieDAO {
	
	/**
	 * Logger.
	 */
	private static final Log LOG = LogFactoryImpl.getLog(CategorieDAOImpl.class);
	
	
	

	public CategorieDAOImpl() {
		super();
		
	}

	@Override
	public CategorieEntity getEntityFromDTO(CategorieDTO dto) {
		
		return CategorieUtility.convertDtoToEntity(dto);
	}

	@Override
	public CategorieDTO getDTOFromEntity(CategorieEntity entity) {
		
		CategorieDTO categorieDTO = CategorieUtility.convertEntityToDto(entity);
		convertEntityToDto(entity, categorieDTO);
		return categorieDTO;
	}
/*
	@Override
	public void removeCategorieById(Long CategorieId) throws ByblosException {
		
		LOG.debug("Start of ");
	}
	
	*/

	@Override
	public List<CategorieDTO> loadCategorie() {
		List<CategorieDTO> categorieDTOList= new ArrayList<CategorieDTO>();
		StringBuffer query = new StringBuffer("from CategorieEntity c ");
		List<CategorieEntity> resultList= getEntityManager().createQuery(query.toString()).getResultList();
		for (CategorieEntity entity: resultList) {
			categorieDTOList.add(fullConvertEntity(entity));
		}
		return categorieDTOList;
	}
	
	

}

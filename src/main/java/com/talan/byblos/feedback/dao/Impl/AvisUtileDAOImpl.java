package com.talan.byblos.feedback.dao.Impl;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.LogFactoryImpl;
import org.springframework.stereotype.Repository;

import com.talan.byblos.common.dao.impl.generic.GenericDAOImpl;
import com.talan.byblos.common.dto.AvisUtileDTO;
import com.talan.byblos.common.dto.CategorieDTO;
import com.talan.byblos.common.dto.UserDTO;
import com.talan.byblos.common.entities.AvisUtileEntity;
import com.talan.byblos.common.entities.CategorieEntity;
import com.talan.byblos.common.utility.exception.ByblosDataAccessException;
import com.talan.byblos.common.utility.exception.ByblosSecurityException;
import com.talan.byblos.feedback.dao.AvisUtileDAO;
import com.talan.byblos.feedback.dto.AvisUtile;
import com.talan.byblos.feedback.utility.mapping.UtileUtility;

@Repository("AvisUtileDAO")

public class AvisUtileDAOImpl extends GenericDAOImpl<AvisUtileDTO , AvisUtileEntity> implements AvisUtileDAO 
 {
	
	/**
	 * Logger.
	 */
	private static final Log LOG = LogFactoryImpl.getLog(AvisUtileDAOImpl.class);
	
	AvisUtileEntity utile;

	


	@Override
	public AvisUtileEntity getEntityFromDTO(AvisUtileDTO dto) {
		return UtileUtility.convertDtoToEntity(dto);
	}

	@Override
	public AvisUtileDTO getDTOFromEntity(AvisUtileEntity entity) {
		AvisUtileDTO utileDTO = UtileUtility.convertEntityToDTO(entity);
		convertEntityToDto(entity, utileDTO);
			return utileDTO;


	}

	/**
	 * Aficher tout les utiles
	 */
	@Override
	public List<AvisUtileDTO> loadAllUtile() {
		
		List<AvisUtileDTO> utileDTOList= new ArrayList<AvisUtileDTO>();
		StringBuffer query= new StringBuffer("from AvisUtileEntity u ");
		List<AvisUtileEntity> resultList= getEntityManager().createQuery(query.toString()).getResultList();
		for(AvisUtileEntity entity: resultList) {
			utileDTOList.add(fullConvertEntity(entity));
		}
		return utileDTOList;
	}

	
	/**
	 * le nombre d'utile by Id
	 */
	
	@Override
	public Long nbrUtileById(Long id) {
		StringBuffer query = new StringBuffer("select count(u) from AvisUtileEntity u where u.avis.idAvis = ");
		query.append(id);
		Long result = (Long) getEntityManager().createQuery(query.toString()).getSingleResult();
		return result;
	}

	@Override
	public List<AvisUtile> loadnbUtileByAvis() {
		List<AvisUtile> avisUtileList = new ArrayList<AvisUtile>();
		StringBuffer query = new StringBuffer("select id_avis, count(*) from byblos.ref_utile_avis av group by av.id_avis");
		List<Object[]> resources = getEntityManager().createNativeQuery(query.toString()).getResultList();
		for(Object[] obj : resources) {
			AvisUtile av= new AvisUtile();
			av.setIdAvis(getLong(obj[0]));
			av.setNbrUtil(getLong(obj[1])); 
			avisUtileList.add(av);
		}
		return avisUtileList;
	}

	
}

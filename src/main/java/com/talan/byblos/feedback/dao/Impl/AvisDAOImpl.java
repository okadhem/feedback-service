package com.talan.byblos.feedback.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.LogFactoryImpl;
import org.springframework.stereotype.Repository;

import com.talan.byblos.common.dao.impl.generic.GenericDAOImpl;
import com.talan.byblos.common.dto.AvisDTO;
import com.talan.byblos.common.entities.AvisEntity;
import com.talan.byblos.common.entities.FeedbackEntity;
import com.talan.byblos.feedback.dao.AvisDAO;
import com.talan.byblos.feedback.utility.mapping.AvisUtility;


@Repository("AvisDAO")
public class AvisDAOImpl extends GenericDAOImpl<AvisDTO, AvisEntity> implements AvisDAO {

	/**
	 * Logger.
	 */
	private static final Log LOG = LogFactoryImpl.getLog(AvisDAOImpl.class);
	
	AvisEntity av;
	
	@Override
	public AvisEntity getEntityFromDTO(AvisDTO dto) {
		
		return AvisUtility.convertDtoToEntity(dto);
	}

	@Override
	public AvisDTO getDTOFromEntity(AvisEntity entity) {
		
		AvisDTO avisDTO = AvisUtility.convertEntityToDto(entity);
		convertEntityToDto(entity, avisDTO);
		return avisDTO;
	}

	@Override
	public List<AvisDTO> loadAllAvis() {
		List<AvisDTO> avisDTOList= new ArrayList<AvisDTO>();
		StringBuffer query = new StringBuffer("select av from AvisEntity av ");
		List<AvisEntity> resultList= getEntityManager().createQuery(query.toString()).getResultList();
		for(AvisEntity entity:resultList) {
			avisDTOList.add(fullConvertEntity(entity));
			
		}
		return avisDTOList;
	}
	
	
	@Override
public List<AvisDTO> loadAvisByIdTheme(Long id) {

	List<AvisDTO> avisDTOList = new ArrayList<AvisDTO>();
	StringBuffer query = new StringBuffer("select av from AvisEntity av where av.themeAvis.idThemeAvis=");
	query.append(id);
	List<AvisEntity> resultList= getEntityManager().createQuery(query.toString()).getResultList();
	for (AvisEntity entity: resultList) {
		avisDTOList.add(fullConvertEntity(entity));
	}
	return avisDTOList;
}

@Override
public List<Double> moyenneRate(Long idTheme) {
	StringBuffer query= new StringBuffer("select avg(av.rate) from AvisEntity av  where av.themeAvis.idThemeAvis=");
	query.append(idTheme);
	List<Double> result =  getEntityManager().createQuery(query.toString()).getResultList();
	if ( result.size()!=0) {
		return result;
	}
	return null;
}

@Override
public Long NombreParticipants() {
	StringBuffer query = new StringBuffer("select count(fe) from AvisEntity fe");
	Long result = (Long) getEntityManager().createQuery(query.toString()).getSingleResult();
	
	return result;

}
	
}

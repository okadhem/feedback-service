package com.talan.byblos.feedback.dao.Impl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import com.talan.byblos.common.dao.impl.generic.GenericDAOImpl;
import com.talan.byblos.common.dto.CategorieDTO;
import com.talan.byblos.common.dto.ThemeAvisDTO;
import com.talan.byblos.common.entities.CategorieEntity;
import com.talan.byblos.common.entities.ThemeAvisEntity;
import com.talan.byblos.feedback.dao.ThemeAvisDAO;
import com.talan.byblos.feedback.utility.mapping.ThemeAvisUtility;

@Repository("ThemeAvisDAO")
public class ThemeAvisDAOImpl extends GenericDAOImpl<ThemeAvisDTO, ThemeAvisEntity> implements ThemeAvisDAO {

	@Override
	public List<ThemeAvisDTO> loadThemeByUser(Long idUser) {

		List<ThemeAvisDTO> ThemeDTOList = new ArrayList<ThemeAvisDTO>();
		StringBuffer query = new StringBuffer("select ");
		return null;
	}

	@Override
	public ThemeAvisEntity getEntityFromDTO(ThemeAvisDTO dto) {

		return ThemeAvisUtility.convertDtoToEntity(dto);
	}

	@Override
	public ThemeAvisDTO getDTOFromEntity(ThemeAvisEntity entity) {
		ThemeAvisDTO themeAvisDTO = ThemeAvisUtility.convertEntityToDto(entity);
		convertEntityToDto(entity, themeAvisDTO);
		return themeAvisDTO;
	}

	@Override
	public List<ThemeAvisDTO> loadThemeNonTraite(Long idUser) {
		List<ThemeAvisDTO> themeDTOList = new ArrayList<ThemeAvisDTO>();
		Query query = getEntityManager().createNamedQuery("ThemeAvisEntity.loadThemeNonTraiteByIdUser");
		query.setParameter("idUser", idUser);
		List<ThemeAvisEntity> resultList = query.getResultList();
		for (ThemeAvisEntity entity : resultList) {
			themeDTOList.add(fullConvertEntity(entity));
		}
		return themeDTOList;
	}
	
	
	@Override
	public ThemeAvisDTO loadThemeById(Long id) {
		StringBuilder buildQuery = new StringBuilder();
		ThemeAvisDTO dto= new ThemeAvisDTO();
		ThemeAvisEntity result= new ThemeAvisEntity();
		buildQuery.append("select th from ThemeAvisEntity th where th.idThemeAvis= :id");
		Query query = getEntityManager().createQuery(buildQuery.toString());
		query = query.setParameter("id", id);
		
		result = (ThemeAvisEntity) query.getSingleResult(); 
		dto = getDTOFromEntity(result);
		return dto;
	}

	@Override
	public List<ThemeAvisDTO> loadAllThemes() {
		List<ThemeAvisDTO> themeDTOList= new ArrayList<ThemeAvisDTO>();
		StringBuffer query = new StringBuffer("from ThemeAvisEntity c ");
		List<ThemeAvisEntity> resultList= getEntityManager().createQuery(query.toString()).getResultList();
		for (ThemeAvisEntity entity: resultList) {
			themeDTOList.add(fullConvertEntity(entity));
		}
		return themeDTOList;
	}

	

}

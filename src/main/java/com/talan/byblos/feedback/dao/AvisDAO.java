package com.talan.byblos.feedback.dao;

import java.util.List;

import com.talan.byblos.common.dao.generic.GenericDAO;
import com.talan.byblos.common.dto.AvisDTO;
import com.talan.byblos.common.entities.AvisEntity;


public interface AvisDAO extends GenericDAO<AvisDTO, AvisEntity> {
	
	/**
	 * Load All Avis
	 */
	List<AvisDTO> loadAllAvis();
	/**
	 * loqd avis By id theme
	 */
	List<AvisDTO> loadAvisByIdTheme(Long id);
	
	/**
	 * Moyene rate avis par id theme 
	 */
	List<Double> moyenneRate(Long idTheme);

	Long NombreParticipants();
	
}

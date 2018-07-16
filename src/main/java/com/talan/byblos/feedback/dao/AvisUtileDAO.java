package com.talan.byblos.feedback.dao;

import java.util.List;

import com.talan.byblos.common.dao.generic.GenericDAO;
import com.talan.byblos.common.dto.AvisDTO;
import com.talan.byblos.common.dto.AvisUtileDTO;
import com.talan.byblos.common.entities.AvisEntity;
import com.talan.byblos.common.entities.AvisUtileEntity;
import com.talan.byblos.feedback.dto.AvisUtile;

public interface AvisUtileDAO extends GenericDAO<AvisUtileDTO, AvisUtileEntity> {
	/**
	 * Aficher tous les utile
	 */
	public List<AvisUtileDTO> loadAllUtile();
	
	/**
	 * aficher le nombre d'utile par avis
	 */
	public Long nbrUtileById(Long id);
	
	public List<AvisUtile> loadnbUtileByAvis();
	

}

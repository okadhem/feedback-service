package com.talan.byblos.feedback.dao;

import java.util.List;

import com.talan.byblos.common.dao.generic.GenericDAO;
import com.talan.byblos.common.dto.CategorieDTO;
import com.talan.byblos.common.entities.CategorieEntity;
import com.talan.byblos.common.utility.exception.ByblosException;

public interface CategorieDAO extends GenericDAO<CategorieDTO, CategorieEntity> {
	
	/**
	 * Supprimer les categorie By id
	 * @param CategorieId
	 * @throws ByblosException
	 */
	//void removeCategorieById(Long CategorieId) throws ByblosException;
	
	List<CategorieDTO> loadCategorie();

}

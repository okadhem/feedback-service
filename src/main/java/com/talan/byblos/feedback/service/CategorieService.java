package com.talan.byblos.feedback.service;

import java.util.List;

import com.talan.byblos.common.dto.CategorieDTO;

import com.talan.byblos.common.utility.exception.ByblosException;

public interface CategorieService {
	
	/**
	 * Load Categorie
	 * @param categorieId
	 * @return
	 * @throws ByblosException
	 */
	CategorieDTO loadCategorie(Long categorieId) throws ByblosException;
	
	/**
	 * Add a new Categorie
	 * 
	 * @param categorieDTO
	 * @return
	 * @throws ByblosException
	 */
	CategorieDTO ajouterCategorie(CategorieDTO categorieDTO) throws ByblosException;

	
	/**
	 * Delete Categorie By Id
	 * @param categorieId
	 * @throws ByblosException
	 */
	void deleteCategorieById(Long categorieId) throws ByblosException;

	List<CategorieDTO> loadCategorie();
}

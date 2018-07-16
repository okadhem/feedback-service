package com.talan.byblos.feedback.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import org.springframework.transaction.annotation.Transactional;
import com.talan.byblos.common.dto.CategorieDTO;

import com.talan.byblos.common.utility.exception.ByblosException;
import com.talan.byblos.feedback.dao.CategorieDAO;
import com.talan.byblos.feedback.service.CategorieService;

@Service("CategorieService")
@Transactional(propagation= Propagation.SUPPORTS, readOnly = true)
public class CategorieServiceImpl implements CategorieService{

	/** Categorie dao */
	@Autowired
	private CategorieDAO categorieDAO;
	
	@Override
	public CategorieDTO loadCategorie(Long categorieId) throws ByblosException {
		
		
		Long perseId= categorieId;
		if(perseId == null) {
			
		}
		CategorieDTO categorieDTO= null;
		categorieDTO = categorieDAO.load(perseId);
		return categorieDTO;
	}

	@Override
	@Transactional(propagation= Propagation.REQUIRED, readOnly= false, noRollbackFor = Exception.class)
	
	public CategorieDTO ajouterCategorie(CategorieDTO categorieDTO) throws ByblosException {
		
		return categorieDAO.persist(categorieDTO);
	}

	@Override
	public void deleteCategorieById(Long categorieId) throws ByblosException {
		categorieDAO.remove(categorieId);
		
	}

	@Override
	public List<CategorieDTO> loadCategorie() {
		List<CategorieDTO> categorieList= categorieDAO.loadCategorie();
		
		return categorieList;
	}
	
	
	

}

package com.talan.byblos.feedback.utility.mapping;

import com.talan.byblos.common.dto.CategorieDTO;
import com.talan.byblos.common.entities.CategorieEntity;

public class CategorieUtility {

	/**
	 * Instantiates a new categorie utility
	 */
	protected CategorieUtility() {
		
	}
	
	public static CategorieEntity convertDtoToEntity(CategorieDTO categorieDTO) {
		
		CategorieEntity categorieEntity = new CategorieEntity();
		
		categorieEntity.setId(categorieDTO.getId());
		categorieEntity.setTypeCategorie(categorieDTO.getTypeCategorie());
		categorieEntity.setAbriviationCategorie(categorieDTO.getAbriviationCategorie());
		
		return categorieEntity;
	}
	
	public static CategorieDTO convertEntityToDto(CategorieEntity categorieEntity) {
		
		CategorieDTO categorieDTO = new CategorieDTO();
		
		categorieDTO.setId(categorieEntity.getId());
		categorieDTO.setTypeCategorie(categorieEntity.getTypeCategorie());
		categorieDTO.setAbriviationCategorie(categorieEntity.getAbriviationCategorie());
		
		return categorieDTO;
		
	}
}

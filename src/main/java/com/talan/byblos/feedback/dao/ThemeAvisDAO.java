package com.talan.byblos.feedback.dao;

import java.util.List;

import com.talan.byblos.common.dao.generic.GenericDAO;
import com.talan.byblos.common.dto.ThemeAvisDTO;
import com.talan.byblos.common.entities.ThemeAvisEntity;

public interface ThemeAvisDAO extends GenericDAO<ThemeAvisDTO, ThemeAvisEntity> {
	
	/**
	 * Afficher tout les theme
	 */
	List<ThemeAvisDTO> loadThemeByUser(Long idUser); 
	
	/**
	 * Afficher les themes non traite by id User 
	 */
	List<ThemeAvisDTO> loadThemeNonTraite(Long idUser);
	/**
	 * Afficher theme by id
	 */
	ThemeAvisDTO loadThemeById(Long id);
/**
 * load all themes 
 */
	List<ThemeAvisDTO> loadAllThemes();
	
}


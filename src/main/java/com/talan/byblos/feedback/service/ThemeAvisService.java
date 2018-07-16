package com.talan.byblos.feedback.service;
import java.util.List;

import com.talan.byblos.common.dto.ThemeAvisDTO;
import com.talan.byblos.common.utility.exception.ByblosException;

public interface ThemeAvisService {

	/**
	 * afficher les theme non traite by id user
	 * 
	 */
	
	List<ThemeAvisDTO> themeNonTraiter(Long idUser);
	/**
	 * afficher les theme par id
	 */
	
	ThemeAvisDTO loadThemeById(Long id);

	/**
	 * afficher les themes
	 * 
	 */
	
	List<ThemeAvisDTO> Allthemes();
	
	/**
	 * Add un nouveau theme
	 */
	ThemeAvisDTO addTheme(ThemeAvisDTO reponseDTO) throws ByblosException;
	
	
	void DeleteTheme(Long idTheme) throws ByblosException;

}


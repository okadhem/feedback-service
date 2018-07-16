package com.talan.byblos.feedback.utility.mapping;

import java.util.ArrayList;
import java.util.List;

import com.talan.byblos.common.dto.AvisDTO;
import com.talan.byblos.common.dto.CategorieDTO;
import com.talan.byblos.common.dto.ThemeAvisDTO;
import com.talan.byblos.common.entities.AvisEntity;
import com.talan.byblos.common.entities.CategorieEntity;
import com.talan.byblos.common.entities.ThemeAvisEntity;

public class ThemeAvisUtility {

	/**
	 * Instantiates a new utility
	 */
	protected ThemeAvisUtility() {
		
	}
	
public static ThemeAvisEntity convertDtoToEntity(ThemeAvisDTO themeAvisDTO) {
	
	ThemeAvisEntity themeAvisEntity = new ThemeAvisEntity();
	
	themeAvisEntity.setIdThemeAvis(themeAvisDTO.getIdThemeAvis());
	themeAvisEntity.setThemeAvis(themeAvisDTO.getThemeAvis());
	themeAvisEntity.setDateExpiration(themeAvisDTO.getDateExpiration());
	return themeAvisEntity;
	
}

public static ThemeAvisDTO convertEntityToDto(ThemeAvisEntity themeAvisEntity) {
	ThemeAvisDTO themeAvisDTO = new ThemeAvisDTO();
	themeAvisDTO.setIdThemeAvis(themeAvisEntity.getIdThemeAvis());
	themeAvisDTO.setThemeAvis(themeAvisEntity.getThemeAvis());
	themeAvisDTO.setDateExpiration(themeAvisEntity.getDateExpiration());
	
	return themeAvisDTO;
	
}
}





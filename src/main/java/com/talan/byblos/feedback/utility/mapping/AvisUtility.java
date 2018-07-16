package com.talan.byblos.feedback.utility.mapping;

import com.talan.byblos.common.dto.AvisDTO;
import com.talan.byblos.common.entities.AvisEntity;
import com.talan.byblos.common.entities.EmployeeEntity;
import com.talan.byblos.common.entities.ThemeAvisEntity;

public class AvisUtility {
	
	/**
	 * Instantiates a new Avis utility
	 */
	protected AvisUtility() {
		
	}
	
	public static AvisEntity convertDtoToEntity(AvisDTO avisDTO) {
		AvisEntity avisEntity= new AvisEntity();
		avisEntity.setIdAvis(avisDTO.getIdAvis());
		avisEntity.setContenuAvis(avisDTO.getContenu());
		avisEntity.setRate(avisDTO.getRate());
		avisEntity.setUtilite(avisDTO.getUtilite());
		avisEntity.setThemeAvis(new ThemeAvisEntity(avisDTO.getThemeAvis().getIdThemeAvis()));
		avisEntity.setEmploye(new EmployeeEntity(avisDTO.getEmploye().getId()) );
		return avisEntity;
	}
	
	public static AvisDTO convertEntityToDto(AvisEntity avisEntity) {
		
		AvisDTO avisDTO = new AvisDTO();
		
		avisDTO.setIdAvis(avisEntity.getIdAvis());
		avisDTO.setContenu(avisEntity.getContenuAvis());
		avisDTO.setRate(avisEntity.getRate());
		avisDTO.setUtilite(avisEntity.getUtilite());
		if(avisEntity.getThemeAvis()!=null) {
			avisDTO.setThemeAvis(ThemeAvisUtility.convertEntityToDto(avisEntity.getThemeAvis()));
			}

		if(avisEntity.getEmploye()!=null) {
			avisDTO.setEmploye(PersonneUtility.convertEntityToDto(avisEntity.getEmploye()));
		}
		
		return avisDTO;
	}

}



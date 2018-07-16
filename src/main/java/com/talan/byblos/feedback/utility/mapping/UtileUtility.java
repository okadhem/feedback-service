package com.talan.byblos.feedback.utility.mapping;

import com.talan.byblos.common.dto.AvisUtileDTO;
import com.talan.byblos.common.entities.AvisEntity;
import com.talan.byblos.common.entities.AvisUtileEntity;
import com.talan.byblos.common.entities.EmployeeEntity;

public class UtileUtility {
	
	/**
	 * Instantiates a utile utility
	 */
	protected UtileUtility() {
		
	}
	
	/**
	 * Convertir DTO en Entity
	 */
	public static AvisUtileEntity convertDtoToEntity(AvisUtileDTO utileDTO) {
		AvisUtileEntity utileEntity = new AvisUtileEntity();
		
		utileEntity.setIdUtile(utileDTO.getIdUtile());
		utileEntity.setAvis(new AvisEntity(utileDTO.getAvis().getIdAvis()));
		utileEntity.setPersonnel(new EmployeeEntity(utileDTO.getPersonel().getId()));
		
		return utileEntity;
	}

	public static AvisUtileDTO convertEntityToDTO(AvisUtileEntity utileEntity) {
		
		AvisUtileDTO utileDTO = new AvisUtileDTO();
		
		utileDTO.setIdUtile(utileEntity.getIdUtile());
		if(utileEntity.getAvis()!= null) {
			utileDTO.setAvis(AvisUtility.convertEntityToDto(utileEntity.getAvis()));
		}
		
		if(utileEntity.getPersonnel()!= null) {
			utileDTO.setPersonel(PersonneUtility.convertEntityToDto(utileEntity.getPersonnel()));
		}
		
		return utileDTO;
	}
}



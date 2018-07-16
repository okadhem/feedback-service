package com.talan.byblos.feedback.utility.mapping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;

import com.talan.byblos.common.dto.PersonneDTO;
import com.talan.byblos.common.entities.CivilStatusEntity;
import com.talan.byblos.common.entities.CivilityEntity;
import com.talan.byblos.common.entities.EmployeeEntity;

import com.talan.byblos.common.utility.object.ObjectUtility;


public class PersonneUtility {

	/**
	 * Instantiates a new employee utility.
	 */
	protected PersonneUtility() {
	}

	public static EmployeeEntity convertDtoToEntity(PersonneDTO personneDTO,CivilityEntity civility) {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		employeeEntity.setId(personneDTO.getId());

		employeeEntity.setFirstName(personneDTO.getFirstName());
		employeeEntity.setLastName(personneDTO.getLastName());
		employeeEntity.setCivility(civility);
		

		return employeeEntity;
	}

	/**
	 * convertie Entité en DTO.
	 * 
	 * @param employeeEntity
	 *            Entité.
	 * @return DTO convertie.
	 */
	public static PersonneDTO convertEntityToDto(EmployeeEntity employeeEntity) {
		PersonneDTO personneDTO = new PersonneDTO();
		

	
		personneDTO.setId(employeeEntity.getId());
		
		personneDTO.setFirstName(employeeEntity.getFirstName());
		personneDTO.setLastName(employeeEntity.getLastName());
	
		if (employeeEntity.getCivility() != null) {
			ResourceBundle abrvRessBundel =
			ObjectUtility.loadResourceBundle("com.talan.byblos.rh.bundle.locals.abbreviationLabelSettings");
			//if(employeeEntity.getId()!=null) {
				personneDTO.setCivilityId(employeeEntity.getCivility().getId());
		
//				employeeDTO.setCivilityLabel(abrvRessBundel.getString(employeeEntity.getCivility().getAbrev()));
		}

	
		
	


		return personneDTO;
	}
	
}

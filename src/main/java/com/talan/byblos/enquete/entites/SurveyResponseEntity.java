package com.talan.byblos.enquete.entites;

import java.util.List;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.talan.byblos.common.entities.EmployeeEntity;
import com.talan.byblos.common.entities.SubAbstractEntity;

public class SurveyResponseEntity extends SubAbstractEntity {

	@ManyToMany
	EmployeeEntity owner;
	
	@OneToMany
	List<ResponseEntity> responses;
	
	@ManyToOne
	SurveyEntity survey;
	
	
	
}

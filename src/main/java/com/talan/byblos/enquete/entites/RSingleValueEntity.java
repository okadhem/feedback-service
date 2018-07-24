package com.talan.byblos.enquete.entites;

import javax.persistence.Entity;


import com.talan.byblos.enquete.dto.ResponseSingleValueDTO;


@Entity
public class RSingleValueEntity extends ResponseEntity{
	String value;

	@Override
	public ResponseSingleValueDTO toDTO() {
		ResponseSingleValueDTO dto = new ResponseSingleValueDTO() ;
		
		dto.setQuestionId(question.getId());
		dto.setId(id);
		dto.setValue(value);
		
		return dto;
	}
	
	
	//getters and setters
	
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
}

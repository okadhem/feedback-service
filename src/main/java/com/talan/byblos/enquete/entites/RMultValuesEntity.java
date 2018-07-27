package com.talan.byblos.enquete.entites;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;


import com.talan.byblos.enquete.dto.ResponseMultValuesDTO;

@Entity
public class RMultValuesEntity extends ResponseEntity {
	
	@ElementCollection
	List<String> values;
	
	
	@Override
	public ResponseMultValuesDTO toDTO() {
		ResponseMultValuesDTO dto = new ResponseMultValuesDTO();
		dto.setQuestionId(question.getId());
		dto.setId(id);
		dto.setValues(values);
		
		
		return dto;
	}
	
	
	
	//getters and setters
	
	

	public List<String> getValues() {
		return values;
	}

	public void setValues(List<String> values) {
		this.values = values;
	}

}

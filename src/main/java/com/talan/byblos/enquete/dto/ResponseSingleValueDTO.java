package com.talan.byblos.enquete.dto;

import com.talan.byblos.enquete.entites.QuestionEntity;
import com.talan.byblos.enquete.entites.RMultValuesEntity;
import com.talan.byblos.enquete.entites.RSingleValueEntity;
import com.talan.byblos.enquete.entites.ResponseEntity;

public class ResponseSingleValueDTO extends ResponseDTO{
	
	String value;
	
	@Override
	public RSingleValueEntity toEntity() {
		
		RSingleValueEntity responseEntity = new RSingleValueEntity();
		QuestionEntity qEntity = new QuestionEntity();
		qEntity.setId(questionId);
		responseEntity.setQuestion(qEntity);
		responseEntity.setId(id);
		
		responseEntity.setValue(value);
		
		
		return responseEntity;
	}

	
	//getters and setters
	
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}

package com.talan.byblos.enquete.dto;

import java.util.List;

import com.talan.byblos.enquete.entites.QuestionEntity;
import com.talan.byblos.enquete.entites.RMultValuesEntity;


public class ResponseMultValuesDTO extends ResponseDTO{
	List<String> values;

	@Override
	public RMultValuesEntity toEntity() {
		RMultValuesEntity responseEntity = new RMultValuesEntity();
		
		QuestionEntity qEntity = new QuestionEntity();
		qEntity.setId(questionId);
		responseEntity.setQuestion(qEntity);
		responseEntity.setId(id);
		
		responseEntity.setValues(values);
		
		
		return responseEntity;
	}
	
	
	
	//getters and setters

	public List<String> getValues() {
		return values;
	}

	public void setValues(List<String> values) {
		this.values = values;
	}
	
	
	
		
}

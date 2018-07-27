package com.talan.byblos.enquete.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.talan.byblos.common.dto.AbstractDTO;
import com.talan.byblos.enquete.entites.QuestionEntity;
import com.talan.byblos.enquete.entites.ResponseEntity;



@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property="type", include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({
    @JsonSubTypes.Type(value = ResponseMultValuesDTO.class, name = "ResponseMultValues"),

    @JsonSubTypes.Type(value = ResponseSingleValueDTO.class, name = "ResponseSingleValue") }
)



public class ResponseDTO extends AbstractDTO {
	
	protected long questionId;
	protected long id;
	
	
	public ResponseEntity toEntity() {
		ResponseEntity entity = new ResponseEntity();
		QuestionEntity qEntity = new QuestionEntity();
		qEntity.setId(questionId);
		entity.setQuestion(qEntity);
		entity.setId(id);
		return entity;
		
	}
	
	
	
	//getters and setters
	
	
	public long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}
	

}

package com.talan.byblos.enquete.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.talan.byblos.common.constants.ModelConstant;
import com.talan.byblos.common.entities.SubAbstractEntity;
import com.talan.byblos.enquete.dto.ResponseDTO;

@Entity
@Table(name = "ref_response_survey", schema = ModelConstant.SCHEMA)
public class ResponseEntity extends SubAbstractEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected Long id;
	
	
	
	@ManyToOne
	protected QuestionEntity question;
	
	
	
	public ResponseDTO toDTO() {
		ResponseDTO dto = new ResponseDTO();
		
		dto.setQuestionId(question.getId());
		dto.setId(id);
		
		return dto;
		
	}
	
	
	
	
	//getters and setters

	public QuestionEntity getQuestion() {
		return question;
	}

	public void setQuestion(QuestionEntity question) {
		this.question = question;
	}




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}

	
}

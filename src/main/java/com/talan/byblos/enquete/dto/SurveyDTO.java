package com.talan.byblos.enquete.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import com.talan.byblos.common.dto.AbstractDTO;


public class SurveyDTO extends AbstractDTO {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id; 
	
	private String name;
	private Date expirationDate;
	
	
	private List<QuestionDTO> questions = new ArrayList<>();
	
	
	public void addQuestion(QuestionDTO q)
	{
		questions.add(q);
		
	}
	
	// getters and setters
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	public List<QuestionDTO> getQuestions() {
		return questions;
	}
	public void setQuestions(List<QuestionDTO> questions) {
		this.questions = questions;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	

}

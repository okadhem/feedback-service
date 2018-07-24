package com.talan.byblos.enquete.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.talan.byblos.common.dto.AbstractDTO;
import com.talan.byblos.common.dto.PersonneDTO;


public class SurveyDTO extends AbstractDTO {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id; 
	
	private String title;
	
	private Date expirationDate;
	
	private String description;
	
	private List<PersonneDTO> visibility;
	
	private PersonneDTO owner;
	
	
	private List<QuestionDTO> questions = new ArrayList<>();
	
	
	public void addQuestion(QuestionDTO q)
	{
		questions.add(q);
		
	}

	// getters and setters
	
	
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<PersonneDTO> getVisibility() {
		return visibility;
	}

	public void setVisibility(List<PersonneDTO> visibility) {
		this.visibility = visibility;
	}

	public PersonneDTO getOwner() {
		return owner;
	}

	public void setOwner(PersonneDTO owner) {
		this.owner = owner;
	}
	

}

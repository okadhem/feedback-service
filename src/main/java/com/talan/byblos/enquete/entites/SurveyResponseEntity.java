package com.talan.byblos.enquete.entites;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.talan.byblos.common.entities.EmployeeEntity;
import com.talan.byblos.common.entities.SubAbstractEntity;
@Entity
public class SurveyResponseEntity extends SubAbstractEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected Long id;
	
	
	@ManyToOne
	protected EmployeeEntity owner;
	
	@OneToMany(cascade=CascadeType.ALL)
	protected List<ResponseEntity> responses;
	
	@ManyToOne
	protected SurveyEntity survey;

	
	
	
	// getters and setters
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EmployeeEntity getOwner() {
		return owner;
	}

	public void setOwner(EmployeeEntity owner) {
		this.owner = owner;
	}

	public List<ResponseEntity> getResponses() {
		return responses;
	}

	public void setResponses(List<ResponseEntity> responses) {
		this.responses = responses;
	}

	public SurveyEntity getSurvey() {
		return survey;
	}

	public void setSurvey(SurveyEntity survey) {
		this.survey = survey;
	}
	
	
	
}

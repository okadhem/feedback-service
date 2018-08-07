package com.talan.byblos.enquete.entites;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
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

	@EmbeddedId
	SurveyResponseId id = new SurveyResponseId();
	
	

	
	@OneToMany(cascade=CascadeType.ALL)
	protected List<ResponseEntity> responses;
	
	
	
	
	
	// getters and setters
	
	
	

	public EmployeeEntity getOwner() {
		return id.getOwner();
	}

	public void setOwner(EmployeeEntity owner) {
		this.id.setOwner(owner);
	}

	public List<ResponseEntity> getResponses() {
		return responses;
	}

	public void setResponses(List<ResponseEntity> responses) {
		this.responses = responses;
	}

	public SurveyEntity getSurvey() {
		return id.getSurvey();
	}

	public void setSurvey(SurveyEntity survey) {
		this.id.setSurvey(survey);
	}

	public SurveyResponseId getId() {
		return id;
	}

	public void setId(SurveyResponseId id) {
		this.id = id;
	}
	
	
	
}

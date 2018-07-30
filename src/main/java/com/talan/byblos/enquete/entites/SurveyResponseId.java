package com.talan.byblos.enquete.entites;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import com.talan.byblos.common.entities.EmployeeEntity;

@Embeddable
public class SurveyResponseId implements Serializable{

	@ManyToOne
	@JoinColumn(name = "owner_id")
	protected EmployeeEntity owner;
		
	@ManyToOne
	@JoinColumn(name = "survey_id")
	protected SurveyEntity survey;
	
	
	
	
	

	public EmployeeEntity getOwner() {
		return owner;
	}

	public void setOwner(EmployeeEntity owner) {
		this.owner = owner;
	}

	public SurveyEntity getSurvey() {
		return survey;
	}

	public void setSurvey(SurveyEntity survey) {
		this.survey = survey;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		result = prime * result + ((survey == null) ? 0 : survey.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SurveyResponseId other = (SurveyResponseId) obj;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		if (survey == null) {
			if (other.survey != null)
				return false;
		} else if (!survey.equals(other.survey))
			return false;
		return true;
	}
}

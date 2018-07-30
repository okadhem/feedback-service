package com.talan.byblos.enquete.dto;

import java.util.List;

import com.talan.byblos.common.dto.AbstractDTO;
import com.talan.byblos.common.dto.PersonneDTO;

public class SurveyResponseDTO extends AbstractDTO{
	
	
	
	protected PersonneDTO owner;
	
	
	protected List<ResponseDTO> responses;
	
	
	protected long surveyId;
	
	
	// getters and setters





	public PersonneDTO getOwner() {
		return owner;
	}


	public void setOwner(PersonneDTO owner) {
		this.owner = owner;
	}


	public List<ResponseDTO> getResponses() {
		return responses;
	}


	public void setResponses(List<ResponseDTO> responses) {
		this.responses = responses;
	}


	public long getSurveyId() {
		return surveyId;
	}


	public void setSurveyId(long surveyID) {
		this.surveyId = surveyID;
	}
	

}

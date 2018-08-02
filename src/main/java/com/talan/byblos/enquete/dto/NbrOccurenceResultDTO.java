package com.talan.byblos.enquete.dto;

import java.util.Map;

public class NbrOccurenceResultDTO extends ResultReportDTO {
	
	private Map<String, Integer> choices;
	
	
	

	public Map<String, Integer> getChoices() {
		return choices;
	}

	public void setChoices(Map<String, Integer> choices) {
		this.choices = choices;
	}
	
	
	
}

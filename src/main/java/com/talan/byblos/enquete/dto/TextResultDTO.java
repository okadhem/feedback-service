package com.talan.byblos.enquete.dto;

import java.util.Map;

public class TextResultDTO extends ResultReportDTO {

	Map<String,Double> words; // words and frequencies

	public Map<String, Double> getWords() {
		return words;
	}

	public void setWords(Map<String, Double> words) {
		this.words = words;
	}
	
}

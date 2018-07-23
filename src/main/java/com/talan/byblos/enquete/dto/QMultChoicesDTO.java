package com.talan.byblos.enquete.dto;

import java.util.List;

import com.talan.byblos.enquete.entites.QMultChoicesEntity;


public class QMultChoicesDTO extends QuestionDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	List<String> choices;

	
	
	@Override
	public QMultChoicesEntity toEntity() {
		QMultChoicesEntity entity = new QMultChoicesEntity();
		entity.setRequired(required);
		entity.setId(id);
		entity.setLabel(label);
		entity.setChoix(choices);
	
	return entity;
	}
	
	public List<String> getChoices() {
		return choices;
	}

	public void setChoices(List<String> choices) {
		this.choices = choices;
	}
	
	
	

}

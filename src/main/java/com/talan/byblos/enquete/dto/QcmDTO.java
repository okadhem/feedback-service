package com.talan.byblos.enquete.dto;

import java.util.List;

import com.talan.byblos.enquete.entites.QChoixMultiEntity;


public class QcmDTO extends QuestionDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	List<String> choices;

	
	
	@Override
	public QChoixMultiEntity toEntity() {
		QChoixMultiEntity entity = new QChoixMultiEntity();
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

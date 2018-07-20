package com.talan.byblos.enquete.dto;


import com.talan.byblos.enquete.entites.QTextEntity;


public class QTextDTO extends QuestionDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override

	public QTextEntity toEntity() {
		QTextEntity entity = new QTextEntity();
		entity.setRequired(required);
		entity.setId(id);
		entity.setLabel(label);
		
		
		return entity;
	}

}

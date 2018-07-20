package com.talan.byblos.enquete.entites;

import javax.persistence.Entity;
import com.talan.byblos.enquete.dto.QTextDTO;


@Entity
public class QTextEntity extends QuestionEntity {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public QTextDTO toDTO() {
		QTextDTO dto = new QTextDTO();
		
		dto.setId(id);
		dto.setLabel(label);
		
		dto.setRequired(required);
		return dto;
	}
	
}

package com.talan.byblos.enquete.entites;

import javax.persistence.Entity;

import com.talan.byblos.enquete.dto.QDateTimeDTO;
import com.talan.byblos.enquete.dto.QTextDTO;


@Entity
public class QDateTimeEntity extends QuestionEntity {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public QDateTimeDTO toDTO() {
		QDateTimeDTO dto = new QDateTimeDTO();
		
		dto.setId(id);
		dto.setLabel(label);
		
		dto.setRequired(required);
		return dto;
	}
	
}

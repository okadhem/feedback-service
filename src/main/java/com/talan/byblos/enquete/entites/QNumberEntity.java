package com.talan.byblos.enquete.entites;

import javax.persistence.Entity;

import com.talan.byblos.enquete.dto.QNumberDTO;
import com.talan.byblos.enquete.dto.QTextDTO;


@Entity
public class QNumberEntity extends QuestionEntity {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public QNumberDTO toDTO() {
		QNumberDTO dto = new QNumberDTO();
		
		dto.setId(id);
		dto.setLabel(label);
		
		dto.setRequired(required);
		return dto;
	}
	
}

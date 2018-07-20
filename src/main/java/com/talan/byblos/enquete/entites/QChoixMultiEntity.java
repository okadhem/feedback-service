package com.talan.byblos.enquete.entites;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;

import com.talan.byblos.enquete.dto.QcmDTO;




@Entity
public class QChoixMultiEntity extends QuestionEntity {
	
	
	

	private static final long serialVersionUID = 1L;

	
	@ElementCollection
	@Column(name = "option_label")
	List<String> choix;

	
	@Override
	public QcmDTO toDTO()
	{
		QcmDTO dto = new QcmDTO();
		
		
		dto.setId(id);
		dto.setLabel(label);
		
		dto.setRequired(required);
		dto.setChoices(choix);
		
		return dto;
	}

	
	
	
	// getters and setters
	
	public List<String> getChoix() {
		return choix;
	}

	public void setChoix(List<String> choix) {
		this.choix = choix;
	}	
}

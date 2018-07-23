package com.talan.byblos.enquete.entites;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;

import com.talan.byblos.enquete.dto.QMultChoicesDTO;




@Entity
public class QMultChoicesEntity extends QuestionEntity {
	
	
	

	private static final long serialVersionUID = 1L;

	
	@ElementCollection
	@Column(name = "option_label")
	List<String> choices;

	
	@Override
	public QMultChoicesDTO toDTO()
	{
		QMultChoicesDTO dto = new QMultChoicesDTO();
		
		
		dto.setId(id);
		dto.setLabel(label);
		
		dto.setRequired(required);
		dto.setChoices(choices);
		
		return dto;
	}

	
	
	
	// getters and setters
	
	public List<String> getChoix() {
		return choices;
	}

	public void setChoix(List<String> choix) {
		this.choices = choix;
	}	
}

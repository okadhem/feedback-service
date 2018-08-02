package com.talan.byblos.enquete.entites;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;

import com.talan.byblos.enquete.dto.QMultChoicesDTO;
import com.talan.byblos.enquete.dto.QMultChoicesMultAnswersDTO;
import com.talan.byblos.enquete.dto.QuestionDTO;

// a question with different choices and the use can pick more than one answer

@Entity
public class QMultChoicesMultAnswersEntity extends QuestionEntity {
	

	@ElementCollection
	@Column(name = "choices_label")
	List<String> choices;

	
	@Override
	public QMultChoicesMultAnswersDTO toDTO()
	{
		QMultChoicesMultAnswersDTO dto = new QMultChoicesMultAnswersDTO();
		
		
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

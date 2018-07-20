package com.talan.byblos.enquete.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.talan.byblos.common.constants.ModelConstant;
import com.talan.byblos.common.entities.SubAbstractEntity;
import com.talan.byblos.enquete.dto.QuestionDTO;


@Entity
@Table(name = "ref_question", schema = ModelConstant.SCHEMA)
public class QuestionEntity extends SubAbstractEntity{
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_question")
	protected Long id;
	
	@Column(name = "q_label")
	protected String label;
	
	@Column(name = "is_required")
	protected boolean required;
	
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public boolean isRequired() {
		return required;
	}
	public void setRequired(boolean required) {
		this.required = required;
	}
	
	// tmp solution
	
	public QuestionDTO toDTO() {
		QuestionDTO dto = new QuestionDTO();
		dto.setId(id);
		dto.setLabel(label);
		
		dto.setRequired(required);
		return dto;
	}
}

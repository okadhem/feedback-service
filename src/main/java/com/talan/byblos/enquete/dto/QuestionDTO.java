package com.talan.byblos.enquete.dto;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.talan.byblos.common.dto.AbstractDTO;
import com.talan.byblos.enquete.dao.QMultChoicesDAO;
import com.talan.byblos.enquete.dao.QuestionDAO;
import com.talan.byblos.enquete.dao.impl.QMultChoicesDAOImpl;
import com.talan.byblos.enquete.entites.QuestionEntity;
import com.talan.byblos.enquete.utils.NbrOccurenceAggreagator;
import com.talan.byblos.enquete.utils.ResultAggregator;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property="type", include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({
    @JsonSubTypes.Type(value = QMultChoicesDTO.class, name = "QMultChoices"),

    @JsonSubTypes.Type(value = QTextDTO.class, name = "QTextEntity"),
    @JsonSubTypes.Type(value = QMultChoicesMultAnswersDTO.class, name = "QMultChoicesMultAnswers")}
)


public class QuestionDTO extends AbstractDTO{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected long id;
	
	protected String label;
	
	protected boolean required;
	
	
	public QuestionEntity toEntity() {
		QuestionEntity entity = new QuestionEntity();
		entity.setRequired(required);
		entity.setId(id);
		entity.setLabel(label);
		
		return entity;
	}
	
	
	public ResultReportDTO reportResults(QuestionDAO qDAO) {
		return null;
	}
	
	

	// getters and setters
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public boolean isRequired() {
		return required;
	}
	public void setRequired(boolean required) {
		this.required = required;
	}
	
}
package com.talan.byblos.enquete.dto;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.talan.byblos.common.dto.AbstractDTO;
import com.talan.byblos.enquete.entites.QuestionEntity;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property="type", include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({
    @JsonSubTypes.Type(value = QcmDTO.class, name = "Qcm"),

    @JsonSubTypes.Type(value = QTextDTO.class, name = "QTextEntity") }
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
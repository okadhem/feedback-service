package com.talan.byblos.enquete.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.talan.byblos.common.dto.AbstractDTO;
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property="type", include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({
    @JsonSubTypes.Type(value = ResponseMultValuesDTO.class, name = "ResponseMultValues"),

    @JsonSubTypes.Type(value = ResponseSingleValueDTO.class, name = "ResponseSingleValue") }
)
public class ResponseDTO extends AbstractDTO {
	
	long questionId;
	

}

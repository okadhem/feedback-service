package com.talan.byblos.enquete.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property="type", include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({
    @JsonSubTypes.Type(value = NbrOccurenceResultDTO.class, name = "NbrOccurenceResult"),
    @JsonSubTypes.Type(value = NumberReportDTO.class, name = "NumberResult")
}
)
public class ResultReportDTO {

}

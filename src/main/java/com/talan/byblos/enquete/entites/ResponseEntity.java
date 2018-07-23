package com.talan.byblos.enquete.entites;

import javax.persistence.ManyToOne;

import com.talan.byblos.common.entities.SubAbstractEntity;

public class ResponseEntity extends SubAbstractEntity {
	
	@ManyToOne
	QuestionEntity question;
	
	@ManyToOne
	SurveyResponseEntity surveyResponse;
		
}

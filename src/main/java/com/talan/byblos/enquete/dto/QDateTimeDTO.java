package com.talan.byblos.enquete.dto;


import java.util.ArrayList;

import com.talan.byblos.enquete.dao.QuestionDAO;
import com.talan.byblos.enquete.entites.QDateTimeEntity;
import com.talan.byblos.enquete.entites.QTextEntity;
import com.talan.byblos.enquete.exceptions.SurveyExeption;
import com.talan.byblos.enquete.utils.NbrOccurenceAggreagator;


public class QDateTimeDTO extends QuestionDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override

	public QDateTimeEntity toEntity() {
		QDateTimeEntity entity = new QDateTimeEntity();
		entity.setRequired(required);
		entity.setId(id);
		entity.setLabel(label);
		
		
		return entity;
	}
	
	@Override
	public ResultReportDTO reportResults(QuestionDAO qDAO) throws SurveyExeption {
		
		NbrOccurenceAggreagator aggreagator = new NbrOccurenceAggreagator(new ArrayList<>());
		
		qDAO.findAllAnswersByQuestionId(id).stream()
		.map(resp -> (ResponseSingleValueDTO)resp)
		.sorted((a,b) -> a.getValue().compareTo(b.getValue()) )
		.forEach(resp -> aggreagator.accumulate(resp));
		
		
		
		return aggreagator.getDTO();
	}

}

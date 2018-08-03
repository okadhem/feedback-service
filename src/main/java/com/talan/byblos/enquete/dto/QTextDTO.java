package com.talan.byblos.enquete.dto;


import java.util.List;

import com.talan.byblos.enquete.dao.QuestionDAO;
import com.talan.byblos.enquete.entites.QTextEntity;
import com.talan.byblos.enquete.exceptions.SurveyExeption;
import com.talan.byblos.enquete.utils.TextAggreagator;


public class QTextDTO extends QuestionDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override

	public QTextEntity toEntity() {
		QTextEntity entity = new QTextEntity();
		entity.setRequired(required);
		entity.setId(id);
		entity.setLabel(label);
		
		
		return entity;
	}

	
	@Override
	public ResultReportDTO reportResults(QuestionDAO qDAO){
		
		List<ResponseDTO> responses = qDAO.findAllAnswersByQuestionId(id);
		
		TextAggreagator aggregator = new TextAggreagator();
		
		
		responses.forEach(resp -> aggregator.accumulate((ResponseSingleValueDTO) resp));
		
		
		return aggregator.getDTO();
	}
}

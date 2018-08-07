package com.talan.byblos.enquete.dto;


import com.talan.byblos.enquete.dao.QuestionDAO;
import com.talan.byblos.enquete.entites.QNumberEntity;
import com.talan.byblos.enquete.entites.QTextEntity;
import com.talan.byblos.enquete.exceptions.SurveyExeption;
import com.talan.byblos.enquete.utils.NumberAggreagator;
import com.talan.byblos.enquete.utils.ResultAggregator;


public class QNumberDTO extends QuestionDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override

	public QNumberEntity toEntity() {
		QNumberEntity entity = new QNumberEntity();
		entity.setRequired(required);
		entity.setId(id);
		entity.setLabel(label);
		
		
		return entity;
	}
	
	@Override
	public ResultReportDTO reportResults(QuestionDAO qDAO) throws SurveyExeption {
		
		NumberAggreagator aggregator = new NumberAggreagator();
		
		qDAO.findAllAnswersByQuestionId(id)
			.forEach(resp -> aggregator.accumulate((ResponseSingleValueDTO)resp));
		
		
		
		
		return aggregator.getDTO();
	}

}

package com.talan.byblos.enquete.dto;

import java.util.List;

import com.talan.byblos.enquete.dao.QuestionDAO;
import com.talan.byblos.enquete.entites.QMultChoicesEntity;
import com.talan.byblos.enquete.utils.NbrOccurenceAggreagator;
import com.talan.byblos.enquete.utils.ResultAggregator;


public class QMultChoicesDTO extends QuestionDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	List<String> choices;
	
	
	public ResultReportDTO reportResults(QuestionDAO qDAO) {
		
		
		ResultAggregator aggregator = new NbrOccurenceAggreagator(choices);
		
		
		List<ResponseDTO> responses = qDAO.findAllAnswersByQuestionId(id);
		
		
		responses.forEach(resp -> {
			if(resp instanceof ResponseSingleValueDTO) {
				aggregator.accumulate((ResponseSingleValueDTO)resp);	
			}
			if(resp instanceof ResponseMultValuesDTO)
			{
				aggregator.accumulate((ResponseMultValuesDTO)resp);	
			}
				
		});
		
		
		return aggregator.getDTO();

		
	}
		
	
	
	
	@Override
	public QMultChoicesEntity toEntity() {
		QMultChoicesEntity entity = new QMultChoicesEntity();
		entity.setRequired(required);
		entity.setId(id);
		entity.setLabel(label);
		entity.setChoix(choices);
	
	return entity;
	}
	

	
	
	public List<String> getChoices() {
		return choices;
	}

	public void setChoices(List<String> choices) {
		this.choices = choices;
	}
	
	
	

}

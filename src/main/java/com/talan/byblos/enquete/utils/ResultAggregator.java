package com.talan.byblos.enquete.utils;

import com.talan.byblos.enquete.dto.ResponseMultValuesDTO;
import com.talan.byblos.enquete.dto.ResponseSingleValueDTO;
import com.talan.byblos.enquete.dto.ResultReportDTO;
import com.talan.byblos.enquete.exceptions.SurveyExeption;

public abstract class ResultAggregator {
	
	abstract public void accumulate(ResponseSingleValueDTO response);
	
	abstract public void accumulate(ResponseMultValuesDTO response);
	
	abstract public ResultReportDTO getDTO() throws SurveyExeption;
	

}

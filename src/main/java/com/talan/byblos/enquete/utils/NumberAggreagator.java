package com.talan.byblos.enquete.utils;


import com.talan.byblos.enquete.dto.NumberReportDTO;
import com.talan.byblos.enquete.dto.ResponseMultValuesDTO;
import com.talan.byblos.enquete.dto.ResponseSingleValueDTO;
import com.talan.byblos.enquete.dto.ResultReportDTO;
import com.talan.byblos.enquete.exceptions.SurveyExeption;


public class NumberAggreagator extends ResultAggregator {

	
	double average;
	double max;
	double min;
	int population; // how many numbers where accumulated until now
	
	public NumberAggreagator() {
		population = 0;
		average = 0;
		min = Double.POSITIVE_INFINITY;
		max = Double.NEGATIVE_INFINITY;
	
	}
	
	
	
	
	
	
	@Override
	public void accumulate(ResponseSingleValueDTO response) {
		double val = Double.parseDouble(response.getValue());
		
		average = (average * population + val) / (population + 1);
		
		population++;
		
		max = Double.max(max, val);
		min = Double.min(val, min);
		
		
	}
	
	

	
	
	@Override
	public void accumulate(ResponseMultValuesDTO response) {
		response.getValues().forEach(resp ->
		{
		
		double val = Double.parseDouble(resp);
		
		average = (average * population + val) / (population + 1);
		
		population++;
		
		max = Double.max(max, val);
		min = Double.min(val, min);
		});
	}
	
	
	
	
	
	

	@Override
	public ResultReportDTO getDTO() throws SurveyExeption {
	  if(population < 1)
	  {
		throw new SurveyExeption("can't calculate result report for a survey with no answers");
	  }
	  
	  NumberReportDTO report = new NumberReportDTO();
	  report.setAverage(average);
	  report.setMax(max);
	  report.setMin(min);
	  return report;
	  
	}
	
	
}

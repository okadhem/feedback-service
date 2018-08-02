package com.talan.byblos.enquete.utils;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.talan.byblos.enquete.dto.NbrOccurenceResultDTO;
import com.talan.byblos.enquete.dto.ResponseMultValuesDTO;
import com.talan.byblos.enquete.dto.ResponseSingleValueDTO;
import com.talan.byblos.enquete.dto.ResultReportDTO;

public class NbrOccurenceAggreagator extends ResultAggregator {
	
	Map<String, Integer> choices;
	
	public  NbrOccurenceAggreagator(List<String> choiceLabels) {
		choices = new TreeMap<>();
		choiceLabels.forEach(label -> choices.put(label, 0));
		
		
	}
	
	@Override
	public void accumulate(ResponseSingleValueDTO response) {
		String val = response.getValue();
		if(choices.containsKey(val))
		{
			choices.put(val,choices.get(val) + 1);		
			
		}
		else
		{
			choices.put(val, 1);
		}
		
	}

	@Override
	public ResultReportDTO getDTO() {
		NbrOccurenceResultDTO res = new NbrOccurenceResultDTO();
		res.setChoices(choices);
		return res;
	}

	@Override
	public void accumulate(ResponseMultValuesDTO response) {
		response.getValues().forEach(val -> {
			if(choices.containsKey(val))
			{
				choices.put(val,choices.get(val) + 1);		
			
			}
			else
			{
				choices.put(val, 1);
			}
		
		});
	}

}

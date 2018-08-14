package com.talan.byblos.enquete.utils;


import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.atlascopco.hunspell.Hunspell;
import com.talan.byblos.enquete.dto.NumberReportDTO;
import com.talan.byblos.enquete.dto.ResponseMultValuesDTO;
import com.talan.byblos.enquete.dto.ResponseSingleValueDTO;
import com.talan.byblos.enquete.dto.ResultReportDTO;
import com.talan.byblos.enquete.dto.TextResultDTO;
import com.talan.byblos.enquete.exceptions.SurveyExeption;


public class TextAggreagator extends ResultAggregator {

	
	int numberOfWords = 0;
	
	Map<String, Integer> wordMap;
	
	List<String> ignoreList;
	
	Hunspell hunspell;
	
	
	public TextAggreagator() {
		wordMap = new TreeMap<>();
		ignoreList = new ArrayList<>();
		URL urlAff = getClass().getResource("fr.aff");
		URL urlDic = getClass().getResource("fr.dic");
		
		String hunspellDictionaryPath = urlDic.getPath();
		
		String hunspellDictionaryTreePath = urlAff.getPath();
		
		hunspell = new Hunspell(hunspellDictionaryPath, hunspellDictionaryTreePath);
		
	
	}
	
	
	
	
	
	
	@Override
	public void accumulate(ResponseSingleValueDTO response) {
		String val = response.getValue();
		
		
		Arrays.asList((val.split(" "))).stream()
		.map(w -> { 
			if(!hunspell.spell(w))
				return hunspell.suggest(w).get(0);
			return w;	
		})
		.filter(w -> !ignoreList.contains(w))
		.forEach(this::putWordIntoMap);
		
		
	}
	
	
	
	
	
	
	
	private void putWordIntoMap(String w) {
		if(wordMap.containsKey(w))
		{
			wordMap.put(w,wordMap.get(w) + 1);		
			
		}
		else
		{
			wordMap.put(w, 1);
		}
		
		numberOfWords++;
		
	}
	

	
	
	
	
	
	@Override
	public void accumulate(ResponseMultValuesDTO response) {
		
		
		response.getValues().forEach(val -> {
		Arrays.asList((val.split(" "))).stream()
		.map(w -> { 
			if(!hunspell.spell(w))
				return hunspell.suggest(w).get(0);
			return w;	
		})
		.filter(w -> !ignoreList.contains(w))
		.forEach(this::putWordIntoMap);
		});
		
		
	}
	
	
	
	
	
	

	@Override
	public ResultReportDTO getDTO(){
		
		Map<String, Double> words = new TreeMap<>();
		TextResultDTO report = new TextResultDTO();
		if(numberOfWords >= 1)
		{
			
			wordMap.forEach((k,v) -> {
				words.put(k, (double)v / (double)numberOfWords);
			
		});
		}
		
		
		report.setWords(words);
		
		return report;
		
	  
	}
	
	
}

package com.talan.byblos.enquete.dto;

import java.util.Map;

public class NumberReportDTO extends ResultReportDTO {
	
	double average;
	double max;
	double min;
	
	
	public double getAverage() {
		return average;
	}
	public void setAverage(double average) {
		this.average = average;
	}
	public double getMax() {
		return max;
	}
	public void setMax(double max) {
		this.max = max;
	}
	public double getMin() {
		return min;
	}
	public void setMin(double min) {
		this.min = min;
	}
	
	
}

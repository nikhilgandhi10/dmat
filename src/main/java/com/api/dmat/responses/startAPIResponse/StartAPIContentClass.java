package com.api.dmat.responses.startAPIResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "Returns Generated Assessment Id , Assessment Duration, "
						+ "Assessment Duration Warning & the total no. of Categories in the Assessment ")
@Component
public class StartAPIContentClass {
	@Value("#{new Integer('${assessmentDurationWarning}')}")
	private int assessmentDurationWarning ;	
	
	private String tabs ;
	private int assessmentID ;
	
	@Value("#{new Integer('${assessmentDuration}')}")
	private int assessmentDuration;
	

	public StartAPIContentClass( ) {}
	
	public StartAPIContentClass(int assessmentDurationWarning, int assessmentDuration, String tabs, int assessmentID) {
		super();
		this.assessmentDurationWarning = assessmentDurationWarning;
		this.assessmentDuration = assessmentDuration;
		this.tabs = tabs;
		this.assessmentID = assessmentID;
	}

	public int getAssessmentDurationWarning() {
		return assessmentDurationWarning;
	}

	public String getTabs() {
		return tabs;
	}

	public int getAssessmentID() {
		return assessmentID;
	}

	public int getAssessmentDuration() {
		return assessmentDuration;
	}

	public void setAssessmentDurationWarning(int assessmentDurationWarning) {
		this.assessmentDurationWarning = assessmentDurationWarning;
	}

	public void setTabs(String tabs) {
		this.tabs = tabs;
	}

	public void setAssessmentID(int assessmentID) {
		this.assessmentID = assessmentID;
	}

	public void setAssessmentDuration(int assessmentDuration) {
		this.assessmentDuration = assessmentDuration;
	}
	
	
}

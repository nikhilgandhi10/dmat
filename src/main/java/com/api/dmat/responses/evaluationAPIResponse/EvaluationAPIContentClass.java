package com.api.dmat.responses.evaluationAPIResponse;

import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class EvaluationAPIContentClass {
	private int assessmentId ;
	private Map<String,Object> devopsPractices ;
	private Map<String,Float> displayCategories ;
	
	public EvaluationAPIContentClass() {
		super();
	}
	public EvaluationAPIContentClass(int assessmentId, Map<String, Object> devopsPractices,
			Map<String, Float> displayCategories) {
		super();
		this.assessmentId = assessmentId;
		this.devopsPractices = devopsPractices;
		this.displayCategories = displayCategories;
	}
	public int getAssessmentId() {
		return assessmentId;
	}
	public Map<String, Object> getDevopsPractices() {
		return devopsPractices;
	}
	public Map<String, Float> getDisplayCategories() {
		return displayCategories;
	}
	public void setAssessmentId(int assessmentId) {
		this.assessmentId = assessmentId;
	}
	public void setDevopsPractices(Map<String, Object> devopsPractices) {
		this.devopsPractices = devopsPractices;
	}
	public void setDisplayCategories(Map<String, Float> displayCategories) {
		this.displayCategories = displayCategories;
	}
	
	
}

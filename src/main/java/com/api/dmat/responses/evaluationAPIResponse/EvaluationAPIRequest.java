package com.api.dmat.responses.evaluationAPIResponse;

import org.springframework.stereotype.Component;

@Component
public class EvaluationAPIRequest {
	private int assessmentID ;
	public EvaluationAPIRequest() {
		super();
	}
	public EvaluationAPIRequest(int assessmentID) {
		super();
		this.assessmentID = assessmentID;
	}
	public int getAssessmentID() {
		return assessmentID;
	}
	public void setAssessmentID(int assessmentID) {
		this.assessmentID = assessmentID;
	}
	
	
}

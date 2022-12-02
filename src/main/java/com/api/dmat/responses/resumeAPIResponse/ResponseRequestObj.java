package com.api.dmat.responses.resumeAPIResponse;

public class ResponseRequestObj {
	private int assessmentid ;

	public int getAssessmentid() {
		return assessmentid;
	}

	public void setAssessmentid(int assessmentid) {
		this.assessmentid = assessmentid;
	}

	public ResponseRequestObj() {}
	
	public ResponseRequestObj(int assessmentid) {
		super();
		this.assessmentid = assessmentid;
	}
	
}

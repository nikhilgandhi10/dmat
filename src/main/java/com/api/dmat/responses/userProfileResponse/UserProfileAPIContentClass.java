package com.api.dmat.responses.userProfileResponse;

import java.util.HashMap;

import org.springframework.stereotype.Component;

@Component
public class UserProfileAPIContentClass {
	private int assessmentID;
	
	private HashMap<String, Object> response;

	public UserProfileAPIContentClass() {}
	
	public UserProfileAPIContentClass(int assessmentID, HashMap<String, Object> response) {
		super();
		this.assessmentID = assessmentID;
		this.response = response;
	}

	public int getAssessmentID() {
		return assessmentID;
	}

	public HashMap<String, Object> getResponse() {
		return response;
	}

	public void setAssessmentID(int assessmentID) {
		this.assessmentID = assessmentID;
	}

	public void setResponse(HashMap<String, Object> response) {
		this.response = response;
	}


}

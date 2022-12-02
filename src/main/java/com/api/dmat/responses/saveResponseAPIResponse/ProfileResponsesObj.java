package com.api.dmat.responses.saveResponseAPIResponse;

public class ProfileResponsesObj {
	private String response ;
	private int userProfileID;
	
	public ProfileResponsesObj() {}

	public ProfileResponsesObj(String response, int userProfileID) {
		super();
		this.response = response;
		this.userProfileID = userProfileID;
	}

	public String getResponse() {
		return response;
	}

	public int getUserProfileID() {
		return userProfileID;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public void setUserProfileID(int userProfileID) {
		this.userProfileID = userProfileID;
	}
	
	

	
}

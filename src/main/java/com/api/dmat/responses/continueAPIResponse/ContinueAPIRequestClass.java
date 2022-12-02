package com.api.dmat.responses.continueAPIResponse;

public class ContinueAPIRequestClass {
	private String emailID;

	
	public ContinueAPIRequestClass() {
	}

	public ContinueAPIRequestClass(String emailID) {
		super();
		this.emailID = emailID;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	
}

package com.api.dmat.responses.saveResponseAPIResponse;

public class QuestionsResponseObj {
	private int questionID ;
	private String response ;
	private int devOpsCategoryID ;
	private int displayCategoryID ;
	
	public QuestionsResponseObj() {}
	
	public QuestionsResponseObj(int questionID, String response, int devOpsCategoryID, int displayCategoryID) {
		super();
		this.questionID = questionID;
		this.response = response;
		this.devOpsCategoryID = devOpsCategoryID;
		this.displayCategoryID = displayCategoryID;
	}
	public int getQuestionID() {
		return questionID;
	}
	public String getResponse() {
		return response;
	}
	public int getDevOpsCategoryID() {
		return devOpsCategoryID;
	}
	public int getDisplayCategoryID() {
		return displayCategoryID;
	}
	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public void setDevOpsCategoryID(int devOpsCategoryID) {
		this.devOpsCategoryID = devOpsCategoryID;
	}
	public void setDisplayCategoryID(int displayCategoryID) {
		this.displayCategoryID = displayCategoryID;
	}
	
}

package com.api.dmat.responses.userProfileResponse;

import java.util.List;

public class QuestionsObj {
	private String question;
	private String comments;
	private Iterable<String> options;
	private int devopscategoryid;
	private int displaycategoryid;
	private int questionid;
	private int issubjective;
	private String reason;
	
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Iterable<String> getOptions() {
		return options;
	}
	public void setOptions(Iterable<String> options) {
		this.options = options;
	}
	public int getDevopscategoryid() {
		return devopscategoryid;
	}
	public void setDevopscategoryid(int devopscategoryid) {
		this.devopscategoryid = devopscategoryid;
	}
	public int getDisplaycategoryid() {
		return displaycategoryid;
	}
	public void setDisplaycategoryid(int displaycategoryid) {
		this.displaycategoryid = displaycategoryid;
	}
	public int getQuestionid() {
		return questionid;
	}
	public void setQuestionid(int questionid) {
		this.questionid = questionid;
	}
	public int getIssubjective() {
		return issubjective;
	}
	public QuestionsObj() {
		super();
	}
	public QuestionsObj(String question, String comments, List<String> findprocessoptions, int devopscategoryid,
			int displaycategoryid, int questionid, int issubjective, String reason) {
		super();
		this.question = question;
		this.comments = comments;
		this.options = findprocessoptions;
		this.devopscategoryid = devopscategoryid;
		this.displaycategoryid = displaycategoryid;
		this.questionid = questionid;
		this.issubjective = issubjective;
		this.reason = reason;
	}
	
	public QuestionsObj(String question, String comments,int devopscategoryid,
			int displaycategoryid, int questionid, int issubjective, String reason) {
		super();
		this.question = question;
		this.comments = comments;
		this.devopscategoryid = devopscategoryid;
		this.displaycategoryid = displaycategoryid;
		this.questionid = questionid;
		this.issubjective = issubjective;
		this.reason = reason;
	}
	public void setIssubjective(int issubjective) {
		this.issubjective = issubjective;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
}

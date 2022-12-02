package com.api.dmat.responses.userProfileResponse;

import java.util.List;

public class ProfileQuestionsObj {
	private String question;
	private String comments;
	private List<String> option;
	private int userid;

	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public List<String> getOption() {
		return option;
	}
	public void setOption2(List<String> option) {
		this.option = option;
	}

	public ProfileQuestionsObj(String question,String comments, List<String> option, int userid) {
		super();
		this.userid = userid;
		this.comments = comments;
		this.question = question;
		this.option = option;
	}
	
	public ProfileQuestionsObj() {}
	
	
}

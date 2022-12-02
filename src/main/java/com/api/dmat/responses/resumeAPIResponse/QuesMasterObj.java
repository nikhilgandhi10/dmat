package com.api.dmat.responses.resumeAPIResponse;

import java.util.Date;

import com.api.dmat.model.DevopsPractice;
import com.api.dmat.model.DisplayCategories;

public class QuesMasterObj {
	private int questionid ;
	private String comments ;
	private Date creationdatetime ;
	private String creationmode ;
	private int issubjective ;
	private Date modificationdatetime ;
	private String question ;
	private String reason ;
	private String status ;
	private DevopsPractice devopscategoryid ;
	private DisplayCategories displaycategoryid ;
	
	public QuesMasterObj(int questionid, String comments, Date creationdatetime, String creationmode, int issubjective,
			Date modificationdatetime, String question, String reason, String status, DevopsPractice devopscategoryid,
			DisplayCategories displaycategoryid) {
		super();
		this.questionid = questionid;
		this.comments = comments;
		this.creationdatetime = creationdatetime;
		this.creationmode = creationmode;
		this.issubjective = issubjective;
		this.modificationdatetime = modificationdatetime;
		this.question = question;
		this.reason = reason;
		this.status = status;
		this.devopscategoryid = devopscategoryid;
		this.displaycategoryid = displaycategoryid;
	}
	public int getQuestionid() {
		return questionid;
	}
	public String getComments() {
		return comments;
	}
	public Date getCreationdatetime() {
		return creationdatetime;
	}
	public String getCreationmode() {
		return creationmode;
	}
	public int getIssubjective() {
		return issubjective;
	}
	public Date getModificationdatetime() {
		return modificationdatetime;
	}
	public String getQuestion() {
		return question;
	}
	public String getReason() {
		return reason;
	}
	public String getStatus() {
		return status;
	}
	public DevopsPractice getDevopscategoryid() {
		return devopscategoryid;
	}
	public DisplayCategories getDisplaycategoryid() {
		return displaycategoryid;
	}
	public void setQuestionid(int questionid) {
		this.questionid = questionid;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public void setCreationdatetime(Date creationdatetime) {
		this.creationdatetime = creationdatetime;
	}
	public void setCreationmode(String creationmode) {
		this.creationmode = creationmode;
	}
	public void setIssubjective(int issubjective) {
		this.issubjective = issubjective;
	}
	public void setModificationdatetime(Date modificationdatetime) {
		this.modificationdatetime = modificationdatetime;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setDevopscategoryid(DevopsPractice devopscategoryid) {
		this.devopscategoryid = devopscategoryid;
	}
	public void setDisplaycategoryid(DisplayCategories displaycategoryid) {
		this.displaycategoryid = displaycategoryid;
	}
	
}

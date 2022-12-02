package com.api.dmat.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="questionsmaster")
public class QuestionsMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int questionid ;
	private String comments ;
	private Date creationdatetime ;
	private String creationmode ;
	private int issubjective ;
	private Date modificationdatetime ;
	@Column(length=1000)
	private String question ;
	private String reason ;
	private String status ;
	private int devopscategoryid ;
	private int displaycategoryid ;
	
	public QuestionsMaster() {}
	public QuestionsMaster(int questionid, String comments, Date creationdatetime, String creationmode,
			int issubjective, Date modificationdatetime, String question, String reason, String status,
			int devopscategoryid, int displaycategoryid) {
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
	public void setQuestionid(int questionid) {
		this.questionid = questionid;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Date getCreationdatetime() {
		return creationdatetime;
	}
	public void setCreationdatetime(Date creationdatetime) {
		this.creationdatetime = creationdatetime;
	}
	public String getCreationmode() {
		return creationmode;
	}
	public void setCreationmode(String creationmode) {
		this.creationmode = creationmode;
	}
	public int getIssubjective() {
		return issubjective;
	}
	public void setIssubjective(int issubjective) {
		this.issubjective = issubjective;
	}
	public Date getModificationdatetime() {
		return modificationdatetime;
	}
	public void setModificationdatetime(Date modificationdatetime) {
		this.modificationdatetime = modificationdatetime;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	
	
	
	
	

}

package com.api.dmat.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="questionresponses")
public class QuestionResponses {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	@Column(length=500)
	private String answer ;
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationdatetime ;
	@Column(length=1000)
	private String reason ;
	private int score ;
	private String status ;
	private int assessmentid ;
	private int questionid ;
	
	public QuestionResponses() {}
	
	public QuestionResponses(int id, String answer, Date creationdatetime, String reason, int score, int assessmentid,
			int questionid) {
		super();
		this.id = id;
		this.answer = answer;
		this.creationdatetime = creationdatetime;
		this.reason = reason;
		this.score = score;
		this.assessmentid = assessmentid;
		this.questionid = questionid;
	}

	public QuestionResponses(String answer, int assessmentid, Date creationdatetime, int questionid, int score) {
		super();
		this.answer = answer;
		this.creationdatetime = creationdatetime;
		this.score = score;
		this.assessmentid = assessmentid;
		this.questionid = questionid;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Date getCreationdatetime() {
		return creationdatetime;
	}
	public void setCreationdatetime(Date date) {
		this.creationdatetime = date;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getAssessmentid() {
		return assessmentid;
	}
	public void setAssessmentid(int assessmentid) {
		this.assessmentid = assessmentid;
	}
	public int getQuestionid() {
		return questionid;
	}
	public void setQuestionid(int questionid) {
		this.questionid = questionid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}

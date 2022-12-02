package com.api.dmat.responses.resumeAPIResponse;

import java.util.Date;

public class QuesResponsesObj {
	private int id ;
	private String answer ;
	private Date creationdatetime ;
	private String reason ;
	private int score ;
	private String status ;
	private AssessmentsObj assessmentid ;
	private QuesMasterObj questionid ;
	
	public QuesResponsesObj(int id, String answer, Date creationdatetime, String reason, int score, String status,
			AssessmentsObj assessmentid, QuesMasterObj questionid) {
		super();
		this.id = id;
		this.answer = answer;
		this.creationdatetime = creationdatetime;
		this.reason = reason;
		this.score = score;
		this.status = status;
		this.assessmentid = assessmentid;
		this.questionid = questionid;
	}
	public int getId() {
		return id;
	}
	public String getAnswer() {
		return answer;
	}
	public Date getCreationdatetime() {
		return creationdatetime;
	}
	public String getReason() {
		return reason;
	}
	public int getScore() {
		return score;
	}
	public String getStatus() {
		return status;
	}
	public AssessmentsObj getAssessmentid() {
		return assessmentid;
	}
	public QuesMasterObj getQuestionid() {
		return questionid;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public void setCreationdatetime(Date creationdatetime) {
		this.creationdatetime = creationdatetime;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setAssessmentid(AssessmentsObj assessmentid) {
		this.assessmentid = assessmentid;
	}
	public void setQuestionid(QuesMasterObj questionid) {
		this.questionid = questionid;
	}
	
	
	

}

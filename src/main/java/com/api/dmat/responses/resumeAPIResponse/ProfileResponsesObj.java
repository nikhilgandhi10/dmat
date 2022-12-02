package com.api.dmat.responses.resumeAPIResponse;

import java.util.Date;

public class ProfileResponsesObj {

    private int id;
    private String answer;
    private Date creationdatetime;
    private String status;
    private AssessmentsObj assessmentid ;
    private UsersObj profilequestionid ;
    public ProfileResponsesObj(int id, String answer, Date creationdatetime, String status, AssessmentsObj assessmentsid, UsersObj profilequestionid) {
        this.id = id;
        this.answer = answer;
        this.creationdatetime = creationdatetime;
        this.status = status;
        this.assessmentid = assessmentsid;
        this.profilequestionid = profilequestionid;
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
	public String getStatus() {
		return status;
	}
	public AssessmentsObj getAssessmentid() {
		return assessmentid;
	}
	public UsersObj getProfilequestionid() {
		return profilequestionid;
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
	public void setStatus(String status) {
		this.status = status;
	}
	public void setAssessmentid(AssessmentsObj assessmentid) {
		this.assessmentid = assessmentid;
	}
	public void setProfilequestionid(UsersObj profilequestionid) {
		this.profilequestionid = profilequestionid;
	}
    
}

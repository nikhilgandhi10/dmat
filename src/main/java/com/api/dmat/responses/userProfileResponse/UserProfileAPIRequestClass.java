package com.api.dmat.responses.userProfileResponse;

public class UserProfileAPIRequestClass{
	private int assessmentID;
	private String buname;
	private String emailid;
	private String projectid;
	private String projectname;
	public int getAssessmentID() {
		return assessmentID;
	}
	public void setAssessmentID(int assessmentID) {
		this.assessmentID = assessmentID;
	}
	public String getBuname() {
		return buname;
	}
	public void setBuname(String buname) {
		this.buname = buname;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getProjectid() {
		return projectid;
	}
	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}
	public String getProjectname() {
		return projectname;
	}
	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}
	public UserProfileAPIRequestClass(int assessmentID, String buname, String emailid, String projectid, String projectname) {
		super();
		this.assessmentID = assessmentID;
		this.buname = buname;
		this.emailid = emailid;
		this.projectid = projectid;
		this.projectname = projectname;
	}
	
	public UserProfileAPIRequestClass() {}
}

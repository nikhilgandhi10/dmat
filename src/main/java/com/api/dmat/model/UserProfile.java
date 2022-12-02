package com.api.dmat.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userprofilemaster")
public class UserProfile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userprofileid ;
	private String comments ;
	private Date creationdatetime ;
	private String creationmode ;
	private Date modificationdatetime ;
	private String option1 ;
	private String option2 ;
	private String question ;
	private String status ;
	
	public UserProfile() {}
	
	public UserProfile(int userprofileid, String comments, Date creationdatetime, String creationmode,
			Date modificationdatetime, String option1, String option2, String question, String status) {
		super();
		this.userprofileid = userprofileid;
		this.comments = comments;
		this.creationdatetime = creationdatetime;
		this.creationmode = creationmode;
		this.modificationdatetime = modificationdatetime;
		this.option1 = option1;
		this.option2 = option2;
		this.question = question;
		this.status = status;
	}

	public int getUserprofileid() {
		return userprofileid;
	}

	public void setUserprofileid(int userprofileid) {
		this.userprofileid = userprofileid;
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

	public void setCreationdatetim(Date creationdatetime) {
		this.creationdatetime = creationdatetime;
	}

	public String getCreationmode() {
		return creationmode;
	}

	public void setCreationmode(String creationmode) {
		this.creationmode = creationmode;
	}

	public Date getModificationdatetime() {
		return modificationdatetime;
	}

	public void setModificationdatetime(Date modificationdatetime) {
		this.modificationdatetime = modificationdatetime;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}

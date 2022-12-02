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

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="profileresponses")
public class ProfileResponses {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	@Column(length=1000)
	private String answer ;
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationdatetime ;
	private String status ;
	private int assessmentid ;
	private int profilequestionid ;

	public ProfileResponses() {}
			
	public ProfileResponses(int id, String answer, Date creationdatetime, String status, int assessmentid,int profilequestionid) {
		super();
		this.id = id;
		this.answer = answer;
		this.creationdatetime = creationdatetime;
		this.status = status;
		this.assessmentid = assessmentid;
		this.profilequestionid = profilequestionid;
	}

	public ProfileResponses(String answer, Date creationdatetime, int assessmentid, int profilequestionid) {
		super();
		this.answer = answer;
		this.creationdatetime = creationdatetime;
		this.assessmentid = assessmentid;
		this.profilequestionid = profilequestionid;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getAssessmentid() {
		return assessmentid;
	}

	public void setAssessmentid(int assessmentid) {
		this.assessmentid = assessmentid;
	}

	public int getProfilequestionid() {
		return profilequestionid;
	}

	public void setProfilequestionid(int profilequestionid) {
		this.profilequestionid = profilequestionid;
	}

		
}

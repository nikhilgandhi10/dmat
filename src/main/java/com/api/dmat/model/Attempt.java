package com.api.dmat.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="attempt")
public class Attempt {
	@Id
	private int assessmentid;
	private int attempt=1;
	private int duration ;
	
	public int getAssessmentid() {
		return assessmentid;
	}
	public void setAssessmentid(int assessmentid) {
		this.assessmentid = assessmentid;
	}
	public int getAttempt() {
		return attempt;
	}
	public void setAttempt(int attempt) {
		this.attempt = attempt;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public Attempt() {}
	public Attempt(int assessmentid, int attempt, int duration) {
		super();
		this.assessmentid = assessmentid;
		this.attempt = attempt;
		this.duration = duration;
	}
}

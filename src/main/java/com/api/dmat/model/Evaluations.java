package com.api.dmat.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="evaluations")
public class Evaluations {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	private Date creationdatetime ;
	private int score ;
	private String status ;
	private int assessmentid ;
	private int displaycategoryid ;
	private int levelrecommendationid ;
	
	public Evaluations() {}
	
	public Evaluations(int id, Date creationdatetime, int score, String status, int assessmentid, int displaycategoryid,
			int levelrecommendationid) {
		super();
		this.id = id;
		this.creationdatetime = creationdatetime;
		this.score = score;
		this.status = status;
		this.assessmentid = assessmentid;
		this.displaycategoryid = displaycategoryid;
		this.levelrecommendationid = levelrecommendationid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getCreationdatetime() {
		return creationdatetime;
	}
	public void setCreationdatetime(Date creationdatetime) {
		this.creationdatetime = creationdatetime;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
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
	public int getDisplaycategoryid() {
		return displaycategoryid;
	}
	public void setDisplaycategoryid(int displaycategoryid) {
		this.displaycategoryid = displaycategoryid;
	}
	public int getLevelrecommendationid() {
		return levelrecommendationid;
	}
	public void setLevelrecommendationid(int levelrecommendationid) {
		this.levelrecommendationid = levelrecommendationid;
	}
	
	
}

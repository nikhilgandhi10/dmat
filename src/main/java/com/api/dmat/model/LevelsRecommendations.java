package com.api.dmat.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="levelsrecommendationsmaster")
public class LevelsRecommendations {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	private Date creationdatetime ;
	private String creationmode ;
	private int currentlevel ;
	private int maximumlevel ;
	private Date modificationdatetime ;
	@Column(length=700)
	private String recommendations ;
	private int recommendedlevel ;
	private String status ;
	private int devopscategoryid ;
	
	public LevelsRecommendations() {}
	
	public LevelsRecommendations(int id, Date creationdatetime, String creationmode, int currentlevel, int maximumlevel,
			Date modificationdatetime, String recommendations, int recommendedlevel, String status,
			int devopscategoryid) {
		super();
		this.id = id;
		this.creationdatetime = creationdatetime;
		this.creationmode = creationmode;
		this.currentlevel = currentlevel;
		this.maximumlevel = maximumlevel;
		this.modificationdatetime = modificationdatetime;
		this.recommendations = recommendations;
		this.recommendedlevel = recommendedlevel;
		this.status = status;
		this.devopscategoryid = devopscategoryid;
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

	public String getCreationmode() {
		return creationmode;
	}

	public void setCreationmode(String creationmode) {
		this.creationmode = creationmode;
	}

	public int getCurrentlevel() {
		return currentlevel;
	}

	public void setCurrentlevel(int currentlevel) {
		this.currentlevel = currentlevel;
	}

	public int getMaximumlevel() {
		return maximumlevel;
	}

	public void setMaximumlevel(int maximumlevel) {
		this.maximumlevel = maximumlevel;
	}

	public Date getModificationdatetime() {
		return modificationdatetime;
	}

	public void setModificationdatetime(Date modificationdatetime) {
		this.modificationdatetime = modificationdatetime;
	}

	public String getRecommendations() {
		return recommendations;
	}

	public void setRecommendations(String recommendations) {
		this.recommendations = recommendations;
	}

	public int getRecommendedlevel() {
		return recommendedlevel;
	}

	public void setRecommendedlevel(int recommendedlevel) {
		this.recommendedlevel = recommendedlevel;
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

}

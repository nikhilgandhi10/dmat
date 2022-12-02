package com.api.dmat.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="optionsmaster")
public class OptionsMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private int optionid;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Date creationdatetime;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String creationmode;
	@Column(length=400)
	private String optionname;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private int score;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String status;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private int questionid;
	
	public OptionsMaster() {}
	
	public OptionsMaster(int optionid, Date creationdatetime, String creationmode, String optionname, int score,
			String status, int questionid) {
		super();
		this.optionid = optionid;
		this.creationdatetime = creationdatetime;
		this.creationmode = creationmode;
		this.optionname = optionname;
		this.score = score;
		this.status = status;
		this.questionid = questionid;
	}
	public int getOptionid() {
		return optionid;
	}
	public void setOptionid(int optionid) {
		this.optionid = optionid;
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
	public String getOptionname() {
		return optionname;
	}
	public void setOptionname(String optionname) {
		this.optionname = optionname;
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
	public int getQuestionid() {
		return questionid;
	}
	public void setQuestionid(int questionid) {
		this.questionid = questionid;
	}
	
	
}

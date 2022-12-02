package com.api.dmat.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="assessment")
public class Assessment {
	@Id
	private int assessmentid ;
	private String createdby ;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationdatetime ;
	
	private String modifiedby;
	private Date modificationdatetime ;
	private String status ;
	
	private int userid ;
	
	public Assessment() {}
	
	public Assessment(int assessmentid, String createdby, Date creationdatetime, String modifiedby,
			Date modificationdatetime, String status, int userid) {
		super();
		this.assessmentid = assessmentid;
		this.createdby = createdby;
		this.creationdatetime = creationdatetime;
		this.modifiedby = modifiedby;
		this.modificationdatetime = modificationdatetime;
		this.status = status;
		this.userid = userid;
	}

	public int getAssessmentid() {
		return assessmentid;
	}
	public void setAssessmentid(int assessmentid) {
		this.assessmentid = assessmentid;
	}
	public String getCreatedby() {
		return createdby;
	}
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}
	public Date getCreationdatetime() {
		return creationdatetime;
	}
	public void setCreationdatetime(Date creationdatetime) {
		this.creationdatetime = creationdatetime;
	}
	public String getModifiedby() {
		return modifiedby;
	}
	public void setModifiedby(String modifiedby) {
		this.modifiedby = modifiedby;
	}
	public Date getModificationdatetime() {
		return modificationdatetime;
	}
	public void setModificationdatetime(Date modificationdatetime) {
		this.modificationdatetime = modificationdatetime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	
}

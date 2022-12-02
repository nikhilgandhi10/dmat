package com.api.dmat.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="devopspracticesmaster")
public class DevopsPractice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int devopscategoryid ;
	private Date creationdatetime;
	private String creationmode;
	private Date modificationdatetime;
	private String name ;
	private String status ;
	
	public DevopsPractice() {}
	
	public DevopsPractice(int devopscategoryid, Date creationdatetime, String creationmode, Date modificationdatetime,
			String name, String status) {
		super();
		this.devopscategoryid = devopscategoryid;
		this.creationdatetime = creationdatetime;
		this.creationmode = creationmode;
		this.modificationdatetime = modificationdatetime;
		this.name = name;
		this.status = status;
	}
	public int getDevopscategoryid() {
		return devopscategoryid;
	}
	public void setDevopscategoryid(int devopscategoryid) {
		this.devopscategoryid = devopscategoryid;
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
	public Date getModificationdatetime() {
		return modificationdatetime;
	}
	public void setModificationdatetime(Date modificationdatetime) {
		this.modificationdatetime = modificationdatetime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}

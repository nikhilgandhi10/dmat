package com.api.dmat.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="users")
public class Users {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userid ;
	
	private String buname ;
	private int contact ;
	private String createdby ;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationdatetime ;
	private String emailid ;
	private String firstname ;
	private String lastname ;
	private String modifiedby ;
	private Date modificationdatetime ;
	private String projectid ;
	private String projectname ;
	private String status ;

		
	public Users() {}
	
	public Users(int userid, String buname, int contact, String createdby, Date creationdatetime, String emailid,
			String firstname, String lastname, String modifiedby, Date modificationdatetime, String projectid,
			String projectname, String status) {
		super();
		this.userid = userid;
		this.buname = buname;
		this.contact = contact;
		this.createdby = createdby;
		this.creationdatetime = creationdatetime;
		this.emailid = emailid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.modifiedby = modifiedby;
		this.modificationdatetime = modificationdatetime;
		this.projectid = projectid;
		this.projectname = projectname;
		this.status = status;
	}
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getBuname() {
		return buname;
	}
	public void setBuname(String buname) {
		this.buname = buname;
	}
	public int getContact() {
		return contact;
	}
	public void setContact(int contact) {
		this.contact = contact;
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
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}

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
@Table(name="displaycategoriesmaster")
public class DisplayCategories {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int displaycategoryid ;
	private Date creationdatetime  ;
	private String creationmode ;
	private int maxscore ;
	private Date modificationdatetime ;
	private String name ;
	private String status ;
	
	public DisplayCategories() {};
	
	public DisplayCategories(int displaycategoryid, Date creationdatetime, String creationmode, int maxscore,
			Date modificationdatetime, String name, String status) {
		super();
		this.displaycategoryid = displaycategoryid;
		this.creationdatetime = creationdatetime;
		this.creationmode = creationmode;
		this.maxscore = maxscore;
		this.modificationdatetime = modificationdatetime;
		this.name = name;
		this.status = status;
	}
	public int getDisplaycategoryid() {
		return displaycategoryid;
	}
	public void setDisplaycategoryid(int displaycategoryid) {
		this.displaycategoryid = displaycategoryid;
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
	public int getMaxscore() {
		return maxscore;
	}
	public void setMaxscore(int maxscore) {
		this.maxscore = maxscore;
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

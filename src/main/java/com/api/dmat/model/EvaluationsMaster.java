package com.api.dmat.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="evaluationsmaster")
public class EvaluationsMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int evaluationid ;
	private Date creationdatetime ;
	private String creationmode ;
	private int lowerrange ;
	private String maturitylevel ;
	private Date modificationdatetime ;
	private String status ;
	private int upperrange ;
	
	
	public EvaluationsMaster() {}
	
	public EvaluationsMaster(int evaluationid, Date creationdatetime, String creationmode, int lowerrange,
			String maturitylevel, Date modificationdatetime, String status, int upperrange) {
		super();
		this.evaluationid = evaluationid;
		this.creationdatetime = creationdatetime;
		this.creationmode = creationmode;
		this.lowerrange = lowerrange;
		this.maturitylevel = maturitylevel;
		this.modificationdatetime = modificationdatetime;
		this.status = status;
		this.upperrange = upperrange;
	}
	public int getEvaluationid() {
		return evaluationid;
	}
	public void setEvaluationid(int evaluationid) {
		this.evaluationid = evaluationid;
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
	public int getLowerrange() {
		return lowerrange;
	}
	public void setLowerrange(int lowerrange) {
		this.lowerrange = lowerrange;
	}
	public String getMaturitylevel() {
		return maturitylevel;
	}
	public void setMaturitylevel(String maturitylevel) {
		this.maturitylevel = maturitylevel;
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
	public int getUpperrange() {
		return upperrange;
	}
	public void setUpperrange(int upperrange) {
		this.upperrange = upperrange;
	}
	
	
}

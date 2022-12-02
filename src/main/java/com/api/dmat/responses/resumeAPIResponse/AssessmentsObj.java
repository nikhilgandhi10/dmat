package com.api.dmat.responses.resumeAPIResponse;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;

public class AssessmentsObj {
    private int assessmentid;
    private Date creationdatetime;
    private Date modificationdatetime;
    private String status;

    @Autowired 
    UsersObj userid;


    public AssessmentsObj(int assessmentid, Date date, java.util.Date date2, String status,UsersObj userid) {
        this.assessmentid = assessmentid;
        this.creationdatetime = date;
        this.modificationdatetime = date2;
        this.status = status;
        this.userid = userid;
    }
 

    public UsersObj getUser() {
        return userid;
    }
    public void setUser(UsersObj user) {
        this.userid = user;
    }
    public int getAssessmentid() {
        return assessmentid;
    }
    public void setAssessmentid(int assessmentid) {
        this.assessmentid = assessmentid;
    }
    public Date getCreationdatetime() {
        return creationdatetime;
    }
    public void setCreationdatetime(Date creationdatetime) {
        this.creationdatetime = creationdatetime;
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
    
 
    
    
}

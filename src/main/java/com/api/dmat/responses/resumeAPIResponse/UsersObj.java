package com.api.dmat.responses.resumeAPIResponse;

import java.util.Date;

public class UsersObj {
    private int userid;
    private String buname;
    private Date creationdatetime;
    private String emailid;
    private Date modificationdatetime;  //modificationdatetime instead of modificationtime
    private String projectid;
    private String projectname;
    private String status;

    
    public UsersObj(int userid, String buname, Date creationdatetime, String emailid, Date modificationdatetime,
            String projectid, String projectname, String status) {
                
        this.userid = userid;
        this.buname = buname;
        this.creationdatetime = creationdatetime;
        this.emailid = emailid;
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

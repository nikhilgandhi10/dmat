package com.api.dmat.helper;



import java.util.Date;

import org.springframework.stereotype.Component;


@Component
public class DownloadReportResponseHelper {
    private int assessmentid;
    private String emailid;
    private String projectid;
    private String projectName;
    private String buname;
    private String assessementStatus;
    private String createdAt;
    public int getAssessmentid() {
        return assessmentid;
    }
    public void setAssessmentid(int assessmentid) {
        this.assessmentid = assessmentid;
    }
    public String getEmailid() {
        return emailid;
    }
    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }
    public String getProjectid() {
        return projectid;
    }
    public void setProjectid(String projectid) {
        this.projectid = projectid;
    }
    public String getProjectName() {
        return projectName;
    }
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    public String getBuname() {
        return buname;
    }
    public void setBuname(String buname) {
        this.buname = buname;
    }
    public String getAssessementStatus() {
        return assessementStatus;
    }
    public void setAssessementStatus(String assessementStatus) {
        this.assessementStatus = assessementStatus;
    }
    public String getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
    public DownloadReportResponseHelper(int assessmentid, String emailid, String projectid, String projectName,
            String buname, String assessementStatus, String createdAt) {
        super();
        this.assessmentid = assessmentid;
        this.emailid = emailid;
        this.projectid = projectid;
        this.projectName = projectName;
        this.buname = buname;
        this.assessementStatus = assessementStatus;
        this.createdAt = createdAt;
    }
    
    public DownloadReportResponseHelper() {}
    
    
}
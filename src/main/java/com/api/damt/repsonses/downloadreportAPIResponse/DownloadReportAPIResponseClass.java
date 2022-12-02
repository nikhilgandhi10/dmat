package com.api.damt.repsonses.downloadreportAPIResponse;
public class DownloadReportAPIResponseClass {
    private String message;
    private String status;
    private Integer statusCode;


   public String getMessage() {
        return message;
    }


   public void setMessage(String message) {
        this.message = message;
    }



   public String getStatus() {
        return status;
    }



   public void setStatus(String status) {
        this.status = status;
    }



   public Integer getStatusCode() {
        return statusCode;
    }



   public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

 public DownloadReportAPIResponseClass(String message, String status, Integer statusCode) {
        this.message = message;
        this.status = status;
        this.statusCode = statusCode;
    }

   public DownloadReportAPIResponseClass() {
    }
}
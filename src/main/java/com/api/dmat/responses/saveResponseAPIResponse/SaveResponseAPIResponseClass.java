package com.api.dmat.responses.saveResponseAPIResponse;

import org.springframework.http.HttpStatus;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "Returns Message ,Status ,Status Code")
public class SaveResponseAPIResponseClass {
	private String message ;
	private HttpStatus status ;
	private int statusCode ;
	
	
	public SaveResponseAPIResponseClass(){}
	
	public SaveResponseAPIResponseClass(String message, HttpStatus status, int ok) {
		this.message = message;
		this.status = status;
		this.statusCode = ok;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	
}

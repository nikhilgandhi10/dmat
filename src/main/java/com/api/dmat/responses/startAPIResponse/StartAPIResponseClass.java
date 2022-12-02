package com.api.dmat.responses.startAPIResponse;

import org.springframework.http.HttpStatus;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "Returns Message ,Status ,Status Code and Content for the Start Assessment")
public class StartAPIResponseClass {
	private String message ;
	private HttpStatus status ;
	private int statusCode ;
	private StartAPIContentClass content;
	
	
	public StartAPIResponseClass(){}
	
	public StartAPIResponseClass(String message, HttpStatus ok, int statusCode, StartAPIContentClass content) {
		this.message = message;
		this.status = ok;
		this.statusCode = statusCode;
		this.content = content;
	}
	
	public StartAPIContentClass getContent() {
		return content;
	}

	public void setContent(StartAPIContentClass content) {
		this.content = content;
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

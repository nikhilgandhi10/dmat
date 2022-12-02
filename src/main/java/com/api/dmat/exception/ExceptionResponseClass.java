package com.api.dmat.exception;

import org.springframework.http.HttpStatus;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "Class used to return the global exceptions that are handled ")
public class ExceptionResponseClass {
	private String message ;
	private HttpStatus status ;
	private int statusCode ;
	
	public ExceptionResponseClass() {}
	public ExceptionResponseClass(String message, HttpStatus status, int statusCode) {
		super();
		this.message = message;
		this.status = status;
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	
	

}

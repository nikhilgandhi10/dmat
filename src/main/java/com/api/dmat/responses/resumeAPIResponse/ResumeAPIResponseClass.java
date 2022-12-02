package com.api.dmat.responses.resumeAPIResponse;

import java.util.Map;

import org.springframework.http.HttpStatus;

public class ResumeAPIResponseClass {
	private String message;
	private HttpStatus status;
	private int statusCode;
	private Map<String,Object> content;

	public ResumeAPIResponseClass() {}

	public ResumeAPIResponseClass(String message, HttpStatus status, int statusCode, Map<String, Object> content) {
		super();
		this.message = message;
		this.status = status;
		this.statusCode = statusCode;
		this.content = content;
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

	public Map<String, Object> getContent() {
		return content;
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

	public void setContent(Map<String, Object> content) {
		this.content = content;
	}
	
	
}

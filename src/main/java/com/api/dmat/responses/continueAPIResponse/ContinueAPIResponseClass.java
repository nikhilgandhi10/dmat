package com.api.dmat.responses.continueAPIResponse;

import org.springframework.http.HttpStatus;


public class ContinueAPIResponseClass {

	private String message;
	private int statusCode;
	HttpStatus status;
	private Object content;
	
	
	
	public ContinueAPIResponseClass() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ContinueAPIResponseClass(String message, Object content, HttpStatus status) {
		super();
		this.message = message;
		this.content = content;
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getContent() {
		return content;
	}
	public void setContent(Object content) {
		this.content = content;
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
	@Override
	public String toString() {
		return "Resp [message=" + message + ", statusCode=" + statusCode + ", content=" + content + "]";
	}
	
	
}

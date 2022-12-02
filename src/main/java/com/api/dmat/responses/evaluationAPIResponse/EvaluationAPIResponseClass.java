package com.api.dmat.responses.evaluationAPIResponse;

import org.springframework.stereotype.Component;

@Component
public class EvaluationAPIResponseClass {
	private String message ;
	private String status ;
	private int statusCode ;
	private EvaluationAPIContentClass content ;
	
	public EvaluationAPIResponseClass() {
		super();
	}
	public EvaluationAPIResponseClass(String message, String status, int statusCode,
			EvaluationAPIContentClass content) {
		super();
		this.message = message;
		this.status = status;
		this.statusCode = statusCode;
		this.content = content;
	}

	public String getMessage() {
		return message;
	}
	public String getStatus() {
		return status;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public EvaluationAPIContentClass getContent() {
		return content;
	}
	public void setContent(EvaluationAPIContentClass content) {
		this.content = content;
	}
	
	
}

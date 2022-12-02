package com.api.dmat.responses.userProfileResponse;

public class UserProfileAPIResponseClass {
	private String message;
	private String status;
	private Integer statusCode;
	private UserProfileAPIContentClass content;

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

	public UserProfileAPIContentClass getContent() {
		return content;
	}

	public void setContent(UserProfileAPIContentClass content) {
		this.content = content;
	}

	public UserProfileAPIResponseClass(String message, String status, Integer statusCode) {
		this.message = message;
		this.status = status;
		this.statusCode = statusCode;
	}

	public UserProfileAPIResponseClass(String message, String status, Integer statusCode, UserProfileAPIContentClass content) {
		this.message = message;
		this.status = status;
		this.statusCode = statusCode;
		this.content = content;
	}

	public UserProfileAPIResponseClass() {
	}
}

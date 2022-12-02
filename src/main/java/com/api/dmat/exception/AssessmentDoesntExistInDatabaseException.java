package com.api.dmat.exception;

public class AssessmentDoesntExistInDatabaseException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public AssessmentDoesntExistInDatabaseException(String message){
		super(message);
	}
}

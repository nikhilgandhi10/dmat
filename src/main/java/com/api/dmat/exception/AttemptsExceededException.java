package com.api.dmat.exception;

public class AttemptsExceededException extends Exception{

	private static final long serialVersionUID = 1298357084444658975L;
	
	public AttemptsExceededException(String message){
		super(message);
	}

}

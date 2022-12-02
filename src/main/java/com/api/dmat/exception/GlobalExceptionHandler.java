package com.api.dmat.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Configuration
@ConfigurationProperties(prefix = "response.messages")
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	@Value(value = "${invalidAssessmentId}")
	private String invalidAssessmentIdMessage ;
	@Value(value = "${invalidRequest}")
	private String invalidRequestMessage ;
	@Value(value="${attemptsExceeded}")
	private String attemptsExceededMessage ;
	@Value(value = "${unknownError}")
	private String unknownErrorMessage ;
	@Value(value = "${assessmentDoesntExist}")
	private String assessmentDoesntExistsMessage ;

	
	@ExceptionHandler(value = InvalidAssessmentIdException.class)
	public ResponseEntity<ExceptionResponseClass> invalidAssessmentIdResponse(InvalidAssessmentIdException exception ){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new ExceptionResponseClass(invalidAssessmentIdMessage, 
						HttpStatus.BAD_REQUEST ,
						HttpStatus.BAD_REQUEST.value()));
	}
	
	@ExceptionHandler(value = InvalidRequestException.class)
	public ResponseEntity<ExceptionResponseClass> invalidResponse(InvalidRequestException exception ){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new ExceptionResponseClass(invalidRequestMessage,
						HttpStatus.BAD_REQUEST,
						HttpStatus.BAD_REQUEST.value()));
	}
	
	@ExceptionHandler(value = AttemptsExceededException.class)
	public ResponseEntity<ExceptionResponseClass> attemptsExceededResponse(AttemptsExceededException exception ){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new ExceptionResponseClass(attemptsExceededMessage,
						HttpStatus.BAD_REQUEST,
						HttpStatus.BAD_REQUEST.value()));
	}

	@ExceptionHandler(value = AssessmentDoesntExistInDatabaseException.class)
	public ResponseEntity<ExceptionResponseClass> assessmentNotExistInDatabase(AssessmentDoesntExistInDatabaseException exception ){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new ExceptionResponseClass(assessmentDoesntExistsMessage,
						HttpStatus.BAD_REQUEST,
						HttpStatus.BAD_REQUEST.value()));
	}

}

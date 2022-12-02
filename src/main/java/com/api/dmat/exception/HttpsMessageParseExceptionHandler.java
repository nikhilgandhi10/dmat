package com.api.dmat.exception;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class HttpsMessageParseExceptionHandler extends ResponseEntityExceptionHandler{
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
		HttpHeaders headers, HttpStatus status, WebRequest request) {	
		JSONObject errorJSON = new JSONObject();
		try {
			errorJSON.put("message","HttpMessageParseException : Not Readable");
			errorJSON.put("status",status.value());
			errorJSON.put("error",status.getReasonPhrase());		
		} catch (JSONException e) {
			System.err.println("Json Exception");
		}
		return new ResponseEntity<>(errorJSON.toString(),status);
	}
	
}

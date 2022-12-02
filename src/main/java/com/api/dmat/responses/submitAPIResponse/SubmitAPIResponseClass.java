package com.api.dmat.responses.submitAPIResponse;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class SubmitAPIResponseClass {
	// Generates a response 
	public  static ResponseEntity<Object>generateResponse(String message,String statusmessage,HttpStatus status){
		Map<String,Object>map=new HashMap<>();
		map.put("message", message);
		map.put("status", statusmessage);
		map.put("statusCode",status.value());
		return  new ResponseEntity<Object>(map,status) ;
	}
}

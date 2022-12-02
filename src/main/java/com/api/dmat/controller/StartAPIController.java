package com.api.dmat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.dmat.responses.startAPIResponse.StartAPIResponseClass;
import com.api.dmat.service.StartAPIService;

import io.swagger.annotations.ApiOperation;

@RestController
public class StartAPIController {
	
	@Autowired
	private StartAPIService service ;

	
	@ApiOperation(value="Starts the Assessment for the Current User" , 
				  notes="Generates an 8 Digit Assessment Id for the User and adds the record to the database. "
				  		+ "Also returns the assessment details including the Assessment Duration Time , Assessment Duration Warning Time,"
				  		+ " and related message ,status and status code regarding the assessment session")
	@RequestMapping(value = "assessment/start", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<StartAPIResponseClass> startAssessment() {
		return ResponseEntity.status(HttpStatus.OK)
				.body(new StartAPIResponseClass("AssessmentId generated successfully",
						HttpStatus.OK ,
						HttpStatus.OK.value(),
						service.getContent()));
	}
}

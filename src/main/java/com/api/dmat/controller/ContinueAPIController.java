package com.api.dmat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.dmat.exception.AssessmentDoesntExistInDatabaseException;
import com.api.dmat.responses.continueAPIResponse.ContinueAPIRequestClass;
import com.api.dmat.responses.continueAPIResponse.ContinueAPIResponseClass;
import com.api.dmat.service.ContinueAPIService;

import io.swagger.annotations.ApiOperation;

@RestController
public class ContinueAPIController {

	@Autowired
	private ContinueAPIService service;

	// @PostMapping("")

	// This method help to post request with email id. which return type object.
	@ApiOperation(value="Retrieves the latest assessment status details "
					, notes = "fetches the data from user table by email id and returns status of latest assessment"
							+ " taken by the user ")
	@RequestMapping(value = "/assessment/continue", method = RequestMethod.POST, produces = "application/json") 
	public ResponseEntity<Object> continueAssessment(@RequestBody ContinueAPIRequestClass request) throws AssessmentDoesntExistInDatabaseException {
		// Response store in object Response class object.
		ContinueAPIResponseClass respModel = service.getAssesmentdata(request.getEmailID());

		// Here response return the latest assessment detail status.
		return new ResponseEntity<>(respModel, respModel.getStatus());
	}

}

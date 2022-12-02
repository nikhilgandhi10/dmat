package com.api.dmat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.dmat.exception.AssessmentDoesntExistInDatabaseException;
import com.api.dmat.exception.InvalidAssessmentIdException;
import com.api.dmat.responses.evaluationAPIResponse.EvaluationAPIRequest;
import com.api.dmat.service.EvaluationAPIService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/assessment")
public class EvaluationAPIController {

	@Autowired
	EvaluationAPIService service;
	
	@ApiOperation(value = "Evaluates the responses that are given by the user ",
				  notes = "Matches the option & scores & gives scores as well as the recommendations " )
	@RequestMapping(value = "/evaluate", method = RequestMethod.POST, produces = "application/json")
	public Object evaluation(@RequestBody EvaluationAPIRequest evaluationRequest) throws InvalidAssessmentIdException, AssessmentDoesntExistInDatabaseException{   
		long assessmentid = evaluationRequest.getAssessmentID();
    	return service.getEvaluations(assessmentid);
	}
}





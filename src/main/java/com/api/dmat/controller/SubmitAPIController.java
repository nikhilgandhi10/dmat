package com.api.dmat.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.dmat.exception.InvalidRequestException;
import com.api.dmat.helper.SubmitAPIValidationHelper;
import com.api.dmat.service.SubmitAPIService;

import io.swagger.annotations.ApiOperation;

@RestController
public class SubmitAPIController {
	@Autowired
	SubmitAPIService service;
	@Autowired
	SubmitAPIValidationHelper helper;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SubmitAPIController.class);

	@ApiOperation(value="Submits the Assessment & completes the assessment " , 
			  notes="Takes all the mandatory questions from the user , verifies if all are present and if all the "
			  		+ "details are present, validates them , & then submits ( or updates the responses addedd through saveresposne )"
			  		+ "to the responses database ")
	@RequestMapping(value = "assessment/submit", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Object> submitAPI(@RequestBody Map<String, Object> request) throws InvalidRequestException {
		
		Long startTime;
		LOGGER.info("SubmitApi.Controller : Submit API started");
		startTime = System.currentTimeMillis();
		LOGGER.info("SubmitApi.Validation : Validation of Submit API  request started");
		ResponseEntity<Object> submit;
		if (helper.validateRequest(request).getStatusCode() == HttpStatus.OK) {
			LOGGER.info("SubmitApi.Validation : Validation of Submit API  request Successful");
			// Submits the request and returns the Response
			submit = service.submit(request);
		} else {
			submit = helper.validateRequest(request);
			LOGGER.warn("SubmitApi.Validation : Validation of Submit API  request Failed:" + submit.getBody());
		}
		LOGGER.info("SubmitApi.ResponseEntity : Time taken by Submit API: " + (System.currentTimeMillis() - startTime)+ "ms");
		return submit;
	}

}

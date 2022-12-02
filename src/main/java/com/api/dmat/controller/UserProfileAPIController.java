package com.api.dmat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.dmat.exception.InvalidAssessmentIdException;
import com.api.dmat.responses.userProfileResponse.UserProfileAPIRequestClass;
import com.api.dmat.service.UserprofileAPIService;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/assessment")
public class UserProfileAPIController {
	
	@Autowired
	UserprofileAPIService service;

	@ApiOperation(value="Adds User profile to DataBase",
					notes="Checks if the assessmentId is present in DataBase, "+"Fetches the questionmasters data from the Database i.e. the "
							+ "Profile & Category Questions from the table and return it to the client ")
	@RequestMapping(value = "userprofile", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> addUser(@RequestBody UserProfileAPIRequestClass request) throws InvalidAssessmentIdException {
		return service.addUser(request) ;
	}

}

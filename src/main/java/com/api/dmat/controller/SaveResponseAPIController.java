package com.api.dmat.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.dmat.exception.InvalidAssessmentIdException;
import com.api.dmat.exception.InvalidRequestException;
import com.api.dmat.responses.saveResponseAPIResponse.SaveResponseAPIResponseClass;
import com.api.dmat.service.SaveResponseAPIService;
import io.swagger.annotations.ApiOperation;
@Configuration
@ConfigurationProperties(prefix = "response.messages")

@RestController
public class SaveResponseAPIController {
		
	@Value(value = "${unknownError}")
	private String unknownErrorMessage ;
	@Value(value = "${success}")
	private String successMessage ;
	
	@Autowired
	private SaveResponseAPIService service ;

		
	@ApiOperation(value="Saves the Assessment Response from for the User" , 
				  notes="Saves the response that is given by the user to profileresponses and questionresponses table "
				  		+ ", after validation of response and also updates the duration in attempts table  ")
	@RequestMapping(value = "saveresponse", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<SaveResponseAPIResponseClass> saveResponse(@RequestBody Map<String,Object> responseList) throws InvalidAssessmentIdException, InvalidRequestException {
		//Saves the assessment responses in case of no exceptions and returns true
		boolean status = service.saveResponse(responseList);
		// if Success 
		if(status){
			return ResponseEntity.status(HttpStatus.OK).body(new SaveResponseAPIResponseClass(successMessage, 
							HttpStatus.OK ,HttpStatus.OK.value()));
		}
		// If failed with no exception,throws Unknown error message
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new SaveResponseAPIResponseClass(unknownErrorMessage,
						HttpStatus.BAD_REQUEST,HttpStatus.BAD_REQUEST.value()));
	}

}


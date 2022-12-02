package com.api.dmat.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.api.dmat.exception.AssessmentDoesntExistInDatabaseException;
import com.api.dmat.model.Assessment;
import com.api.dmat.model.Users;
import com.api.dmat.repo.AssessmentRepo;
import com.api.dmat.repo.UsersRepo;
import com.api.dmat.responses.continueAPIResponse.ContinueAPIResponseClass;

@Service
public class ContinueAPIService {

	@Autowired
	UsersRepo usersrepo;

	@Autowired
	AssessmentRepo assessmentrepo;

	private static final Logger LOGGER = LoggerFactory.getLogger(ContinueAPIService.class);
	// This function help the user to fetch data from respective email
	public ContinueAPIResponseClass getAssesmentdata(String email) throws AssessmentDoesntExistInDatabaseException {

		// create ResponseClass object to store and return the response.
		ContinueAPIResponseClass response = new ContinueAPIResponseClass();
		
		//Start Time Log
		long startTime ;
		startTime = System.currentTimeMillis() ;
		LOGGER.info("Continue API Started ");
		
		// single email id have multiple user id and store in list.
		List<Users> userList = usersrepo.findByEmailid(email);

		// check list contains any data.
		// if size 0 then else condition will run.
		if (userList.size() == 0) {
			LOGGER.info("ID Doesnt exist in database  ");
			LOGGER.info("Time Taken : "+ ( System.currentTimeMillis()-startTime)+"ms");

			throw new AssessmentDoesntExistInDatabaseException("Data for Assessment ID doesnt Exist") ;
		}
		else {
			// get the last data from list and return to the user.
			Users user = userList.get(userList.size() - 1);
			// fetch assessment details for for userid which fetch from userList.
			Assessment assessment = assessmentrepo.findByUserid(user.getUserid());
			// store the response in Response class.
			Map<Object, Object> map = new HashMap<>();
			map.put("Status", assessment.getStatus());
			map.put("assessmentID", assessment.getAssessmentid());
			response.setMessage("Latest Assessment details returned successfully");
			response.setStatus(HttpStatus.OK);
			response.setStatusCode(HttpStatus.OK.value());
			response.setContent(map);
			
			//Success Log & response
			LOGGER.info("Retreived User Assessment Data");
			LOGGER.info("Time Taken : "+ ( System.currentTimeMillis()-startTime)+"ms");
			return response;
		}
	}
}

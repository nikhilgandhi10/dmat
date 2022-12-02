package com.api.dmat.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.dmat.exception.InvalidAssessmentIdException;
import com.api.dmat.exception.InvalidRequestException;
import com.api.dmat.helper.DBHelper;
import com.api.dmat.model.Attempt;
import com.api.dmat.model.ProfileResponses;
import com.api.dmat.model.QuestionResponses;
import com.api.dmat.repo.AttemptRepo;
import com.api.dmat.repo.ProfileResponsesRepo;
import com.api.dmat.repo.QuestionMasterRepo;
import com.api.dmat.repo.QuestionResponsesRepo;
import com.api.dmat.responses.saveResponseAPIResponse.ProfileResponsesObj;
import com.api.dmat.responses.saveResponseAPIResponse.QuestionsResponseObj;
import com.api.dmat.utility.ValidationUtility;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component

public class SaveResponseAPIService {
	
	@Autowired
	private DBHelper helper;
	@Autowired
	private ValidationUtility utility ;
	@Autowired
	private ProfileResponsesRepo profileresponserepo;
	@Autowired 
	private QuestionResponsesRepo questionresponserepo ;
	@Autowired
	private QuestionMasterRepo questionmasterrepo ;
	@Autowired 
	private AttemptRepo attemptrepo ;
	
	
	private static long startTime ;
	private static final Logger LOGGER = LoggerFactory.getLogger(SaveResponseAPIService.class);
	
	// get the tab names using the helper class
	public  List<String> getTabNames() {
		return helper.displayCategoryTabs();
	}
	
	
	//------------------------------------ Method to validate  AssessmentId--------------------------------------------
	public boolean checkAssessmentId(Map<String, Object> responseList) {
		// checks whether 8 digit or not
		Integer assessmentid = (Integer) responseList.get("assessmentID");
		boolean digitCheck = utility.digitChecker((Long.valueOf(assessmentid.longValue())));
		boolean databaseCheck = utility.assessmentIdValidator(assessmentid);
		// checks whether the assessment id exists in the assessment id table
		return digitCheck && databaseCheck;
	}


	//-------------------------------------- Method to validate and save the incoming response---------------------------------------//
	public synchronized boolean saveResponse(Map<String, Object> responseList) throws InvalidAssessmentIdException, InvalidRequestException {
		
		// Saving & logging Started 
		SaveResponseAPIService.startTime = System.currentTimeMillis();
		LOGGER.info("Save Response API Started ");
		LOGGER.info("Validating Response");
		
		
		// checks all validation related to assessmentId
		boolean assessmentIdCheck = checkAssessmentId(responseList);
		// returns if assessment id validation failed 
		if (!assessmentIdCheck) {
			LOGGER.info("Save Failed : Invalid Assessment Id");
			throw new InvalidAssessmentIdException("Invalid AssessmentId Missing");			
		}
		Integer assessmentid = (Integer) responseList.get("assessmentID");

		//---------------------------------------------------Saves to the Attempts Table Duration-----------------------------------//
		// Updates the duration for the assessment id in the attempts table 
		Object duration = responseList.get("duration") ;
		// if duration not provided then will throw an error 
		if(duration==null) {
			LOGGER.info("Save Failed : Invalid Request");
			throw new InvalidRequestException("Duration Missing");
		}
		Attempt attempt = new Attempt();
		attempt.setAssessmentid(assessmentid);
		attempt.setDuration((int)duration);
		attemptrepo.save(attempt);
			
		
		// ---------------------------------------------Saving Profile Responses------------------------------------------------------//
		// Fetches the list of Profile responses from the request		
		ObjectMapper profileresponsemapper = new ObjectMapper();
		List<ProfileResponsesObj> profileresponesList = profileresponsemapper.convertValue(responseList.get("Project Overview"),new TypeReference<List<ProfileResponsesObj>>() { });
		if (profileresponesList != null) {
			// Saves each response in the list of profileresponse
			for (ProfileResponsesObj presponse : profileresponesList) {
				// fetch the details from incoming profilerepsonse list
				String response = presponse.getResponse();
				int profileQuestionId = presponse.getUserProfileID();
				if(profileQuestionId==0) {
					LOGGER.info("Save Failed : Invalid Response");
					throw new InvalidRequestException("ProfileQuestionId Missing");
				}

				ProfileResponses profileresponse = new ProfileResponses();
				// Checks if record already Present 
				ProfileResponses existingresponse = profileresponserepo.findByAssessmentidAndProfilequestionid(assessmentid,profileQuestionId);
				// if already present then overwrites
				if (existingresponse != null) {
					// set the new object primary key as the one already present and overwrite
					profileresponse.setId(existingresponse.getId());
				}
				// Save the  new profileresponse object
				profileresponse.setAnswer(response);
				profileresponse.setAssessmentid(assessmentid);
				profileresponse.setProfilequestionid(profileQuestionId);
				profileresponse.setCreationdatetime(helper.getCurrentDateTime());
				// if not then saves to profileresponses database
				profileresponserepo.save(profileresponse);
			}
		}

		// --------------------------------------------Saving Question Responses------------------------------------------------------//
		// Fetches the list of Question responses from the request		
			ObjectMapper questionresponsemapper = new ObjectMapper();
			// Retrieve all the Category Names present
			for(String category : getTabNames()) {
				// For each category fetches the responses 
				List<QuestionsResponseObj> questionsresponesList = questionresponsemapper.convertValue(responseList.get(category),new TypeReference<List<QuestionsResponseObj>>() { });
				if (questionsresponesList != null) {
					// Saves each response in the list of Questionresponse
					for (QuestionsResponseObj qresponse : questionsresponesList) {
						// fetch the details from incoming Questionsrepsonse list
						int questionId = qresponse.getQuestionID();
						String response = qresponse.getResponse();
						// if question id feild is null , the
						if(questionId==0) {
							LOGGER.info("Save Failed :Question Id Missing ,  Invalid Response");
							throw new InvalidRequestException("QuestionId Missing");
						}
						// Checks whether the questio id exists or not 
						if(!questionmasterrepo.existsByQuestionid(questionId)) {
							LOGGER.info("Save Failed : Question id doesnt exist in database , Invalid Response");
							throw new InvalidRequestException("QuestionId Doesnt Exist");
						}
						QuestionResponses quesresponse = new QuestionResponses();
						// Checks if record already Present 
						QuestionResponses existingresponse = questionresponserepo.findByAssessmentidAndQuestionid(assessmentid,questionId);
						// if already present then overwrites
						if (existingresponse != null) {
							// set the new object primary key as the one already present and overwrite
							quesresponse.setId(existingresponse.getId());
						}		
						// Save the  new questions response object
						quesresponse.setAnswer(response);
						quesresponse.setAssessmentid(assessmentid);
						quesresponse.setQuestionid(questionId);
						quesresponse.setCreationdatetime(helper.getCurrentDateTime());
						// if not then saves to questions response  database
						questionresponserepo.save(quesresponse);
					}
				}
			}
		
		// Returns true after successful completion of the API response 
			LOGGER.info("Assessment Response Saved Successfully");
			LOGGER.info("Time Taken  :  " + ( System.currentTimeMillis() - startTime )+ " ms");

		return true ;
	}
}

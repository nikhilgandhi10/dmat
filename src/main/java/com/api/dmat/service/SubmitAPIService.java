package com.api.dmat.service;

import java.util.List;
import java.util.Map;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import com.api.dmat.exception.InvalidRequestException;
import com.api.dmat.model.Assessment;
import com.api.dmat.model.ProfileResponses;
import com.api.dmat.model.QuestionResponses;
import com.api.dmat.repo.OptionsMasterRepo;
import com.api.dmat.repo.ProfileResponsesRepo;
import com.api.dmat.repo.QuestionResponsesRepo;
import com.api.dmat.responses.submitAPIResponse.SubmitAPIResponseClass;
import com.api.dmat.utility.DBUtility;
import com.api.dmat.repo.AssessmentRepo;
import com.api.dmat.repo.DisplayCategoriesRepo;

@Component
public class SubmitAPIService {
	
	enum Status {
		ACTIVE,
		COMPLETE,
		OBSOLETE
	}
	
	@Autowired
	QuestionResponsesRepo questionresponserepo;

	@Autowired
	OptionsMasterRepo optionsmasterrepo;

	@Autowired
	ProfileResponsesRepo profileresponserepo;

	@Autowired
	DisplayCategoriesRepo displaycategoriesrepo;
	
	@Autowired 
	AssessmentRepo assessmentrepo ;

	@Autowired
	DBUtility utility;

	@SuppressWarnings("unchecked")
	public ResponseEntity<Object> submit(Map<String, Object> request) throws InvalidRequestException {
		// retrieves the assessment id from the request
		int assessmnetid = (int) request.get("assessmentID");
		// for each category , submit the responses

		List<String> displaycategorynameslist = utility.getDisplayCategoryTabNames();

		for (String category : displaycategorynameslist) {
			submitCategoryQuestions((List<Map<String, Object>>) request.get(category), assessmnetid);
		}
		// to submit the profileResponses
		submitProfileQuestions((List<Map<String, Object>>) request.get("Project Overview"), assessmnetid);
		
		// Changing the Assessment Status to complete on Submission & saves in assessment Table ;
		Assessment assessment = assessmentrepo.findByAssessmentid(assessmnetid);
		assessment.setStatus(Status.COMPLETE.toString());
		assessmentrepo.save(assessment);
		
		// returns the success message 
		return SubmitAPIResponseClass.generateResponse("Assessment Submitted Successfully", "OK", HttpStatus.OK);
	}

	// -----------------------------Method Submit the category wise Questions into the database---------------------------
	public boolean submitCategoryQuestions(List<Map<String, Object>> category, int assessmentid) throws InvalidRequestException {
		// for the entry in option given, calculate score for each question using
		// options master
		for (Map<String, Object> listItem : category) {
			if(listItem.get("response")==null) {
				throw new InvalidRequestException("Null response Found");
			}
			String questionscore = optionsmasterrepo.scoreByOption(listItem.get("response").toString(),(int) listItem.get("questionID"));
			int score = 0;
			if (questionscore != null) {
				score = Integer.parseInt(questionscore);
			}
			// Creates a new entry 
			QuestionResponses latestQuestionResponse = new QuestionResponses();
			latestQuestionResponse.setAnswer(listItem.get("response").toString());
			latestQuestionResponse.setAssessmentid(assessmentid);
			latestQuestionResponse.setCreationdatetime(new Date(System.currentTimeMillis()));
			latestQuestionResponse.setQuestionid((int) listItem.get("questionID"));
			latestQuestionResponse.setScore(score);

			// Checks if already data exists for the question, then rewrites it
			QuestionResponses existingQuestionResponse = questionresponserepo.findByAssessmentidAndQuestionid(assessmentid, (int) listItem.get("questionID"));
			// if exists then updates the previous value
			if (existingQuestionResponse != null) {
				latestQuestionResponse.setId(existingQuestionResponse.getId());
			}
			// Saves the Categoryquestion response entry into the Questions Responses Table
			questionresponserepo.save(latestQuestionResponse);
		}
		return true;

	}

	// --------------------------------Service method to submit all the profile question to the database
	public boolean submitProfileQuestions(List<Map<String, Object>> projectOverview, int assessmentid) throws InvalidRequestException {

		for (Map<String, Object> listItem : projectOverview) {
			
			if(listItem.get("response")==null) {
				throw new InvalidRequestException("Null response Found");
			}
			// Create an entry for the profile responses
			ProfileResponses latestProfileResponses = new ProfileResponses() ;
			latestProfileResponses.setAnswer(listItem.get("response").toString());
			latestProfileResponses.setCreationdatetime(new Date(System.currentTimeMillis()));
			latestProfileResponses.setAssessmentid(assessmentid);
			latestProfileResponses.setProfilequestionid((int) listItem.get("userProfileID"));
			
			// Checks if already data exists for the profile question, then rewrites it
			ProfileResponses existingProfileResponse = profileresponserepo.findByAssessmentidAndProfilequestionid(assessmentid, (int) listItem.get("userProfileID"));

			if (existingProfileResponse != null) {
				latestProfileResponses.setId(existingProfileResponse.getId());
			}
			profileresponserepo.save(latestProfileResponses);
		}
		return true;
	}

}

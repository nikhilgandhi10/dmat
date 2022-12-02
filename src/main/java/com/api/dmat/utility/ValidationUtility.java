package com.api.dmat.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.dmat.repo.AssessmentRepo;
import com.api.dmat.repo.AttemptRepo;
import com.api.dmat.repo.QuestionResponsesRepo;

// Contains all the functions related to validating the entries 
@Component
public class ValidationUtility {
	
	@Autowired 
	private AssessmentRepo assessmentrepo ;
	@Autowired
	private AttemptRepo attemptrepo ;
	@Autowired
	private QuestionResponsesRepo questionresponsesrepo ;
	
	// Validation
	// checks if the given id is 8 digit or not 
	public boolean digitChecker(long assessmentId) {
		if(Long.toString(assessmentId).length()!=8) {
			return false ;
		}
		return true ;
	}
	
	//Checks if id exists or not in the assessment repo 
	public boolean assessmentIdValidator(long assessmentId) {
		if(assessmentrepo.existsById((int)assessmentId)) {
			return true ;				
		}
		return false ;
	}
	
	//Checks if id exists or not in the attempts repo 
	public boolean assessmentIdExistsInAttemptsValidator(long assessmentId) {
		if (attemptrepo.existsById((int) assessmentId)) {
			return true;
		}
		return false;
		}
	//Checks if assessment Id in questionresponses table 
	public boolean assessmentIdExistsInQuestionResponses(long assessmentId) {
		if (questionresponsesrepo.existsByAssessmentid((int) assessmentId)) {
			return true;
		}
		return false;
		}
	
}
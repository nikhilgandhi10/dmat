package com.api.dmat.helper;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.api.dmat.repo.DisplayCategoriesRepo;
import com.api.dmat.responses.submitAPIResponse.SubmitAPIResponseClass;
import com.api.dmat.utility.DBUtility;

@Component
public class SubmitAPIValidationHelper {

	@Autowired
	DisplayCategoriesRepo displaycategoriesrepo;

	@Autowired
	DBUtility utility;

	public ResponseEntity<Object> validateRequest(Map<String, Object> request) {
		// If assessment Id is validated
		if (validateAssessmentID(request).getStatusCode() == HttpStatus.OK
				&& validateCatKeys(request).getStatusCode() == HttpStatus.OK
				&& validateProfile(request).getStatusCode() == HttpStatus.OK
				&& validateNoOfQues(request).getStatusCode() == HttpStatus.OK) {
			// Sends back OK status
			return SubmitAPIResponseClass.generateResponse("Request Validated Successfully", HttpStatus.OK.toString(),
					HttpStatus.OK);
		} else {
			// Else sends the required status message
			if (validateAssessmentID(request).getStatusCode() == HttpStatus.BAD_REQUEST) {
				return validateAssessmentID(request);
			} else if (validateCatKeys(request).getStatusCode() == HttpStatus.BAD_REQUEST) {
				return validateCatKeys(request);
			} else if (validateNoOfQues(request).getStatusCode() == HttpStatus.BAD_REQUEST) {
				return validateNoOfQues(request);
			} else
				return validateProfile(request);
		}
	}

	public ResponseEntity<Object> validateAssessmentID(Map<String, Object> request) {
		if (request.containsKey("assessmentID")) {
			try {
				@SuppressWarnings("unused")
				int assessmentid = (int) request.get("assessmentID");
			} catch (Exception e) {
				return SubmitAPIResponseClass.generateResponse("Invalid Assessment ID", HttpStatus.BAD_REQUEST.toString(),
						HttpStatus.BAD_REQUEST);
			}
		} else {
			return SubmitAPIResponseClass.generateResponse("Assessment id not present", HttpStatus.BAD_REQUEST.toString(),
					HttpStatus.BAD_REQUEST);
		}
		return SubmitAPIResponseClass.generateResponse("Assessment Id validated Successfully", HttpStatus.OK.toString(),
				HttpStatus.OK);

	}

	public ResponseEntity<Object> validateCatKeys(Map<String, Object> request) {
		// Checks whether the category names are present in the table or not

		List<String> displaycategorynameslist = utility.getDisplayCategoryTabNames();

		for (String category : displaycategorynameslist) {
			// if not contains then sends back invalid
			if (!request.containsKey(category)) {
				return SubmitAPIResponseClass.generateResponse(category + " response not present",
						HttpStatus.BAD_REQUEST.toString(), HttpStatus.BAD_REQUEST);
			}
		}
		return SubmitAPIResponseClass.generateResponse("Category names validated successfully", HttpStatus.OK.toString(),
				HttpStatus.OK);
	}

	public ResponseEntity<Object> validateProfile(Map<String, Object> s) {
		if (s.containsKey("Project Overview")) {
			return SubmitAPIResponseClass.generateResponse("Assessment Submitted Successfully", HttpStatus.OK.toString(),
					HttpStatus.OK);
		} else {
			return SubmitAPIResponseClass.generateResponse("Project Overview not present", HttpStatus.BAD_REQUEST.toString(),
					HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<Object> validateNoOfQues(Map<String, Object> request) {
		// For each category , check whether the request has all the questions

		List<String> displaycategorynameslist = utility.getDisplayCategoryTabNames();

		for (String category : displaycategorynameslist) {
			// List of category ques responses in the request
			@SuppressWarnings("unchecked")
			List<Map<String, Object>> categoryResponses = (List<Map<String, Object>>) request.get(category);
			// if size does not match , return as Error missing
			if (categoryResponses.size() != displaycategoriesrepo.noOfQuesbyDisCat(category)) {
				return SubmitAPIResponseClass.generateResponse("Question Responses missing in " + category, HttpStatus.BAD_REQUEST.toString(),
						HttpStatus.BAD_REQUEST);
			}
		}
		return SubmitAPIResponseClass.generateResponse("No.ofQuesValidated",HttpStatus.OK.toString(), HttpStatus.OK);

	}

}

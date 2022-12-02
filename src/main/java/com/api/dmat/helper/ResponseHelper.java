package com.api.dmat.helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.api.dmat.responses.userProfileResponse.ErrorExceptionResponse;
import com.api.dmat.responses.userProfileResponse.UserProfileAPIRequestClass;
import com.api.dmat.utility.ValidationUtility;


@Component
public class ResponseHelper {
		
	@Autowired
	ValidationUtility utility ;

	public Boolean responseValidator(UserProfileAPIRequestClass request) {
		// if any of them null gives as true , the nreturn false 
		return !((request.getBuname()==null || 
				request.getEmailid()==null ||
				(request.getProjectid()==null && request.getProjectname()==null))) ;
	}
	
	public ResponseEntity<ErrorExceptionResponse> responseError(UserProfileAPIRequestClass request){
		if(request.getBuname()==null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ErrorExceptionResponse("BUName not found",
													HttpStatus.BAD_REQUEST.toString(),
													HttpStatus.BAD_REQUEST.value()));
		}
		if(request.getEmailid()==null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ErrorExceptionResponse("EmailId not found",
													HttpStatus.BAD_REQUEST.toString(),
													HttpStatus.BAD_REQUEST.value()));
		}
		if(request.getProjectid()==null && request.getProjectname()==null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ErrorExceptionResponse("Project details not found",
													HttpStatus.BAD_REQUEST.toString(),
													HttpStatus.BAD_REQUEST.value()));
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new ErrorExceptionResponse("New error",
													HttpStatus.BAD_REQUEST.toString(),
													HttpStatus.BAD_REQUEST.value()));	
	}
	
	//checks for assessment id present
	public boolean assessmentIdValidator(UserProfileAPIRequestClass request) {
		long assessmentid = request.getAssessmentID();
		// perform both checks on assessment id from the table 
		return (utility.assessmentIdValidator(assessmentid)&& utility.digitChecker(assessmentid));
	}

}

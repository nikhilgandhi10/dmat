package com.api.dmat.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import com.api.dmat.exception.AttemptsExceededException;
import com.api.dmat.exception.InvalidAssessmentIdException;
import com.api.dmat.helper.ResumeAPIHelper;
import com.api.dmat.model.Assessment;
import com.api.dmat.model.DevopsPractice;
import com.api.dmat.model.DisplayCategories;
import com.api.dmat.model.ProfileResponses;
import com.api.dmat.model.QuestionResponses;
import com.api.dmat.model.QuestionsMaster;
import com.api.dmat.model.Users;
import com.api.dmat.repo.AssessmentRepo;
import com.api.dmat.repo.AttemptRepo;
import com.api.dmat.repo.DevopsPracticeRepo;
import com.api.dmat.repo.DisplayCategoriesRepo;
import com.api.dmat.repo.ProfileResponsesRepo;
import com.api.dmat.repo.QuestionMasterRepo;
import com.api.dmat.repo.QuestionResponsesRepo;
import com.api.dmat.repo.UsersRepo;
import com.api.dmat.responses.resumeAPIResponse.AssessmentsObj;
import com.api.dmat.responses.resumeAPIResponse.ProfileResponsesObj;
import com.api.dmat.responses.resumeAPIResponse.QuesMasterObj;
import com.api.dmat.responses.resumeAPIResponse.QuesResponsesObj;
import com.api.dmat.responses.resumeAPIResponse.ResponseRequestObj;
import com.api.dmat.responses.resumeAPIResponse.ResumeAPIResponseClass;
import com.api.dmat.responses.resumeAPIResponse.UsersObj;

@Component
public class ResumeAPIService {

	@Autowired
	AssessmentRepo assessmentrepo;
	@Autowired
	AttemptRepo attemptrepo;
	@Autowired
	ResumeAPIHelper resumeAPIHelper;
	@Autowired
	QuestionResponsesRepo questionresponsesrepo;
	@Autowired
	ProfileResponsesRepo profileresprepo;
	@Autowired
	UsersRepo userrepo;
	@Autowired
	QuestionMasterRepo questionmasterrepo;
	@Autowired
	DevopsPracticeRepo devopspracticerepo;
	@Autowired
	DisplayCategoriesRepo displaycaterepo;
	@Autowired
	ResumeAPIHelper helper;

	@Value(value = "${unknownError}")
	private String unknownErrorMessage;
	@Value(value = "${success}")
	private String successMessage;
	
	private static final Logger LOGGER =  LoggerFactory.getLogger(ResumeAPIService.class);

	// ------------------------------Returns responses to the controller---------------------
	public ResponseEntity<ResumeAPIResponseClass> getResponses(@RequestBody ResponseRequestObj request)
			throws InvalidAssessmentIdException, AttemptsExceededException {

		long startTime ; 
		// Validation for assessment id
		
		startTime = System.currentTimeMillis() ;
		LOGGER.info("Validation of request started" );
		boolean check = validation(request.getAssessmentid());

		// if success 
		if (check) {
			Map<String,Object> content = new HashMap<>();
			// Calls another service functions 
			content.put("Profile Responses",getProfileResponse(request.getAssessmentid()));
			content.put("Questions Responses",findQuestionResponsesById(request.getAssessmentid()));
			
			LOGGER.info("Assessment Resumed Successfully");
			LOGGER.info("Time Taken by Resume API : + "+(System.currentTimeMillis() - startTime)+"ms");
			return ResponseEntity.status(HttpStatus.OK).body(new ResumeAPIResponseClass(
					"Responses fetched successfully", HttpStatus.OK, HttpStatus.OK.value(), content));
		}
		// if no other exception throws, and still fails , then unknown error
		LOGGER.info("Validation Failed");
		LOGGER.info("Time Taken by Resume API : + "+(System.currentTimeMillis() - startTime)+"ms");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResumeAPIResponseClass(unknownErrorMessage,
				HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(), null));
	}

	
	// ----------------------------------------- Validates resume API request---------------------------------
	public boolean validation(int assessmentid) throws InvalidAssessmentIdException, AttemptsExceededException {
		if (!helper.validator(assessmentid)) {
			throw new InvalidAssessmentIdException("Invalid Assessment Id");
		}
		if (!helper.attemptCheck(assessmentid)) {
			throw new AttemptsExceededException("Attempts total exceeded");
		} else {
			return true;
		}
	}

	// ------------------------- Retrieves the question responses & returns the list  -----------------------
	public List<QuesResponsesObj> findQuestionResponsesById(int assessmentid) {
		List<QuestionResponses> quesresponses = questionresponsesrepo.findByAssessmentid(assessmentid);
		List<QuesResponsesObj> questionresponseobjectList = new ArrayList<>();
		for (QuestionResponses qr : quesresponses) {
			// Gets assessment info
			AssessmentsObj assessmentobj = getAssessment(assessmentid);
			// Gets questionmaster info
			QuesMasterObj questionmasterobj = getQuestionMaster(qr.getQuestionid());
			// Adds it into currentQuestion object List 
			QuesResponsesObj currentquestionresponseobject = new QuesResponsesObj(qr.getId(), qr.getAnswer(), qr.getCreationdatetime(),
					qr.getReason(), qr.getScore(), qr.getStatus(), assessmentobj, questionmasterobj);
			questionresponseobjectList.add(currentquestionresponseobject);
		}
		return questionresponseobjectList;
	}

	//---------Quesmasterdetails for the questionresponselist--------------
	public QuesMasterObj getQuestionMaster(int questionid) {
		QuestionsMaster questionmaster = questionmasterrepo.findByQuestionid(questionid);
		// Fetches the display category and devops practice etails for the given question id 
		DevopsPractice devopspractices = devopspracticerepo.findByDevopscategoryid(questionmaster.getDevopscategoryid());
		DisplayCategories displaycategory = displaycaterepo.findByDisplaycategoryid(questionmaster.getDisplaycategoryid());

		return new QuesMasterObj(questionid, questionmaster.getComments(), questionmaster.getCreationdatetime(),
				questionmaster.getCreationmode(),questionmaster.getIssubjective(), questionmaster.getModificationdatetime(),
				questionmaster.getQuestion(), questionmaster.getReason(), questionmaster.getStatus(),devopspractices, displaycategory);
	}

	// ---------------- gets the profile responses list for the content class -----------
	public List<ProfileResponsesObj> getProfileResponse(int assessmentid) {
		// get profile resp code
		List<ProfileResponsesObj> profileresponsesobjectlist = new ArrayList<>();
		// Fetches the profileResponses
		List<ProfileResponses> totalprofileresponses = profileresprepo.findByAssessmentid(assessmentid);
		
		for(ProfileResponses profileresponse:totalprofileresponses)
		{
			// Gets the assessment Obj
			AssessmentsObj assessmentobj = getAssessment(assessmentid);
			// Gets the users Obj
			UsersObj userobj = getUser(assessmentid);
			// Adds the profile response to the responses list 
			profileresponsesobjectlist.add(new ProfileResponsesObj(profileresponse.getId(), profileresponse.getAnswer(),
					profileresponse.getCreationdatetime(), profileresponse.getStatus(), assessmentobj, userobj));
		}
		return profileresponsesobjectlist ;
	}

	// ------------------- Get users Obj ---------------------------------------------------
	public UsersObj getUser(int assessmentid) {
		Assessment assessment = assessmentrepo.findByAssessmentid(assessmentid);
		Users user = userrepo.findByUserid(assessment.getUserid());
		return new UsersObj(user.getUserid(), user.getBuname(), user.getCreationdatetime(), user.getEmailid(),
				user.getModificationdatetime(), user.getProjectid(), user.getProjectname(), user.getStatus());
	}

	// ------------------- Get assessment Obj ---------------------------------------------------
	public AssessmentsObj getAssessment(int assessmentid) {
		Assessment assessment = assessmentrepo.findByAssessmentid(assessmentid);
		UsersObj user = getUser(assessmentid);
		return new AssessmentsObj(assessmentid, assessment.getCreationdatetime(), assessment.getModificationdatetime(),
				assessment.getStatus(), user);
	}

}

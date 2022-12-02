package com.api.dmat.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import com.api.dmat.exception.InvalidAssessmentIdException;
import com.api.dmat.helper.DBHelper;
import com.api.dmat.helper.ResponseHelper;
import com.api.dmat.model.QuestionsMaster;
import com.api.dmat.model.UserProfile;
import com.api.dmat.repo.AssessmentRepo;
import com.api.dmat.repo.OptionsMasterRepo;
import com.api.dmat.repo.QuestionMasterRepo;
import com.api.dmat.repo.UserProfileRepo;
import com.api.dmat.repo.UsersRepo;
import com.api.dmat.responses.userProfileResponse.ProfileQuestionsObj;
import com.api.dmat.responses.userProfileResponse.QuestionsObj;
import com.api.dmat.responses.userProfileResponse.UserProfileAPIContentClass;
import com.api.dmat.responses.userProfileResponse.UserProfileAPIRequestClass;
import com.api.dmat.responses.userProfileResponse.UserProfileAPIResponseClass;
import com.api.dmat.utility.GenericUtility;

@Component
public class UserprofileAPIService {

	@Autowired
	AssessmentRepo assessrepository;
	@Autowired
	UsersRepo usersrepository;
	@Autowired
	UserProfileRepo userprofilemasterrepository;
	@Autowired
	QuestionMasterRepo questionmasterrepository;
	@Autowired
	OptionsMasterRepo optionsmasterrepository;
	@Autowired
	DBHelper helper;
	@Autowired
	ResponseHelper responsehelper;
	@Autowired
	UserProfileAPIContentClass content;

	// Logger for Userprofile Id
	private static final Logger LOGGER = LoggerFactory.getLogger(UserprofileAPIService.class);

	
	//Method to add a user which further calls other methods from the service 
	public ResponseEntity<?> addUser(UserProfileAPIRequestClass request) throws InvalidAssessmentIdException {
		//StartTime for log 
		Long startTime;
		
		
		//Logging Started
		LOGGER.info("userProfile.ResponseEntity : UserProfileAPI started");
		startTime = System.currentTimeMillis();

		// Checks if all the required project details values are present in the request or not 
		if (!responsehelper.responseValidator(request)) {
			// if reqest doesnt have , then returns error with message
			ResponseEntity<?> responseError = responsehelper.responseError(request);
			
			//Logged the error & time taken 
			LOGGER.error("Request recieved invalid");
			LOGGER.info("userProfile.ResponseEntity : Time taken by userProfile API: "
					+ (System.currentTimeMillis() - startTime) + "ms");
			
			return responseError;
		} else {
			// If valid then checks for assessment Id
			if (!responsehelper.assessmentIdValidator(request)) {
				// if assessment id validation failed return error
				// Logs the error and returns 
				LOGGER.error("Assessment Id invalid");
				LOGGER.info("userProfile.ResponseEntity : Time taken by userProfile API: "+ (System.currentTimeMillis() - startTime) + "ms");
				throw new InvalidAssessmentIdException("UserProfile error : Invalid AssessmentId");
				
			} else {
				// If Valid Assessment then
				// Saves and updates the user id in assessment table 
				synchronized (this) {
					usersrepository.enterUserDetails(request.getBuname(), request.getEmailid(), request.getProjectid(),request.getProjectname(), 999999999,GenericUtility.getCurrentDateTime());
					int assessId = request.getAssessmentID();
					int userId = usersrepository.getLatestUserId();
					assessrepository.updateUserIdWhereAssessmentIdEquals(assessId, userId);
				}
				
				// Gets the profile responses from the service class
				List<ProfileQuestionsObj> projectOverviewQuestions = getallProfileQuestions();
				// Gets the categorywise questions from the service class
				HashMap<String, List<QuestionsObj>> getAllCategoryQuestions = getAllCategoryQuestions(request);

				// Creates response by entering the questions 
				HashMap<String, Object> responses = new HashMap<>();
				responses.put("Project OverView", projectOverviewQuestions);
				List<String> categories = helper.displayCategoryTabs();
				for (int i = 0; i < categories.size(); i++) {
					String categoryName = categories.get(i);
					responses.put(categoryName, getAllCategoryQuestions.get(categoryName));
				}
				
				// sets the response 
				content.setResponse(responses);
				content.setAssessmentID(request.getAssessmentID());

				//Logs the success and returns 
				LOGGER.info("Success");
				LOGGER.info("userProfile.ResponseEntity : Time taken by userProfile API: "
						+ (System.currentTimeMillis() - startTime) + "ms");
				// All success
				return ResponseEntity.status(HttpStatus.OK).body(new UserProfileAPIResponseClass("Master Data Retrieved Successfully",
						HttpStatus.OK.name(), HttpStatus.OK.value(), content));
			}
		}

	}

	// Returns a list of all Profile Project overview Questions
	public List<ProfileQuestionsObj> getallProfileQuestions() {
		List<UserProfile> profilequestions = userprofilemasterrepository.findAll();
		List<ProfileQuestionsObj> getAll = new ArrayList<ProfileQuestionsObj>();
		List<String> getOption = new ArrayList<String>();

		for (UserProfile userprofilequestions : profilequestions) {
			if (userprofilequestions.getOption1() != null) {
				getOption.add(userprofilequestions.getOption1());
			}
			if (userprofilequestions.getOption2() != null) {
				getOption.add(userprofilequestions.getOption2());
			}
			if (getOption.isEmpty()) {
				getOption.clear();
			}
			ProfileQuestionsObj profilequestion = new ProfileQuestionsObj(userprofilequestions.getQuestion(),
					userprofilequestions.getComments(), getOption, userprofilequestions.getUserprofileid());
			getAll.add(profilequestion);
			getOption = new ArrayList<String>();
		}

		return getAll;
	}

	// Returns HashMap of all Category questions
	public HashMap<String, List<QuestionsObj>> getAllCategoryQuestions(UserProfileAPIRequestClass request) {
		// Collects all questions from the questios repo
		List<QuestionsMaster> findAllProcessQuestions = questionmasterrepository.findAll();

		List<String> category = helper.displayCategoryTabs();

		// 49 questions selected
		HashMap<String, List<QuestionsObj>> categoryquestions = new HashMap<>();

		// Create an empty List of categories
		for (int i = 0; i < category.size(); i++) {
			categoryquestions.put(category.get(i), new ArrayList<>());
		}

		for (QuestionsMaster questions : findAllProcessQuestions) {
			// Create empty options list
			List<String> options = new ArrayList<String>();
			// fetch all the questions options from the database for the given question
			List<String> findprocessoptions = optionsmasterrepository.findProcessOptions(questions.getQuestionid());
			Collections.shuffle(findprocessoptions);
			for (int i = 0; i < findprocessoptions.size(); i++) {
				String[] split = findprocessoptions.get(i).split(",");
				options.add(split[3]);
			}
			QuestionsObj question = new QuestionsObj(questions.getQuestion(), questions.getComments(), options,
					questions.getDevopscategoryid(), questions.getDisplaycategoryid(), questions.getQuestionid(),
					questions.getIssubjective(), questions.getReason());

			String currentCategory = category.get(questions.getDevopscategoryid() - 1);
			// existing list of category
			List<QuestionsObj> existingCategoryList = categoryquestions.get(currentCategory);

			// Adds to existing list
			existingCategoryList.add(question);

			// Updates the category List with new Question
			categoryquestions.put(currentCategory, existingCategoryList);
		}

		return categoryquestions;
	}

}

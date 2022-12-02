package com.api.dmat.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.api.dmat.exception.AssessmentDoesntExistInDatabaseException;
import com.api.dmat.exception.InvalidAssessmentIdException;
import com.api.dmat.helper.DBHelper;
import com.api.dmat.model.DevopsPractice;
import com.api.dmat.model.DisplayCategories;
import com.api.dmat.model.LevelsRecommendations;
import com.api.dmat.repo.DisplayCategoriesRepo;
import com.api.dmat.repo.LevelRecomendationRepo;
import com.api.dmat.repo.QuestionMasterRepo;
import com.api.dmat.repo.QuestionResponsesRepo;
import com.api.dmat.responses.evaluationAPIResponse.DevopsPracticesObj;
import com.api.dmat.responses.evaluationAPIResponse.EvaluationAPIContentClass;
import com.api.dmat.responses.evaluationAPIResponse.EvaluationAPIResponseClass;
import com.api.dmat.utility.ValidationUtility;

@Component
public class EvaluationAPIService {

	@Autowired
	EvaluationAPIContentClass content;
	@Autowired
	DBHelper helper;
	@Autowired
	DisplayCategoriesRepo displayactegoriesrepo;
	@Autowired
	LevelRecomendationRepo levelrecommendationsrepo;
	@Autowired
	QuestionResponsesRepo questionsresponsesrepo;
	@Autowired
	QuestionMasterRepo questionmasterRepo;
	@Autowired
	LevelsRecommendations levelsRecommendations;
	@Autowired
	DisplayCategories displayCategories;
	@Autowired
	DevopsPractice devopsPractice;
	@Autowired
	ValidationUtility utility ;

	private static final Logger LOGGER = LoggerFactory.getLogger(EvaluationAPIService.class);
	
	// Returns the evaluations map back to the controller
	public ResponseEntity<EvaluationAPIResponseClass> getEvaluations(long assessmentid) throws InvalidAssessmentIdException, AssessmentDoesntExistInDatabaseException {
		// Validates the assessment Id before evaluations
		// Checks length & if exists in questionresponses table 
		
		
		long startTime = System.currentTimeMillis() ;
		LOGGER.info("Evaluation API Started ");
		LOGGER.info("Validating Assessment Id");
		if (utility.digitChecker(assessmentid) && utility.assessmentIdExistsInQuestionResponses(assessmentid)) {
			EvaluationAPIResponseClass response = new EvaluationAPIResponseClass("Evaluation results fetched successfully",
					HttpStatus.OK.name(), HttpStatus.OK.value(),getContent((int) assessmentid));
			
			LOGGER.info("Evaluated Successfully");
			LOGGER.info("Time Taken : "+ (System.currentTimeMillis() - startTime)+"ms");
			return ResponseEntity.status(HttpStatus.OK).body(response);
		} else {
			if(!utility.digitChecker(assessmentid)) {
				LOGGER.error("Invalid Assessment Id ");
				LOGGER.info("Time Taken : "+ (System.currentTimeMillis() - startTime)+"ms");
				throw new InvalidAssessmentIdException("Invalid Assessment Id");
			}
			else {
				LOGGER.error("Data for Assessment Id Doesnt Exist");
				LOGGER.info("Time Taken : "+ (System.currentTimeMillis() - startTime)+"ms");
				throw new AssessmentDoesntExistInDatabaseException("Data for Assessment Id Doesnt Exist");
			}
		}
	}
	// ----------------Sets and returns the Content class for evaluation response
	public EvaluationAPIContentClass getContent(int assessmentid) {
		content.setAssessmentId(assessmentid);
		content.setDevopsPractices(devopsCategoryScore(assessmentid));
		content.setDisplayCategories(displayCategoryScore(assessmentid));
		return content;
	}

	// --------- sets and returns the displayCategoriesScore to content class------------------------------
	public Map<String, Float> displayCategoryScore(int assessmentId) {
		// Get all display Category Names from helper
		List<String> displayCategoryNamesList = helper.displayCategoryTabs();
		// Empty map of scores
		Map<String, Float> displayCategoryScores = new HashMap<String, Float>();
		// For each category , calculate the score and add to Map
		for (int i = 0; i < displayCategoryNamesList.size(); i++) {
			// Name & id for each Category
			String displaycategoryName = displayCategoryNamesList.get(i);
			int displayCategoryId = i + 1;

			String tempScore = questionsresponsesrepo.CalculateScoreByDisplayCategoryId(assessmentId,displayCategoryId);
			String maxTempScore = questionmasterRepo.maxScoreByDisplayCategoryId(displayCategoryId);
			Double score = Double.parseDouble(tempScore);
			Double maxScore = Double.parseDouble(maxTempScore);
			// Final score average
			Float finalscore = (float) ((score / maxScore) * 100);
			// add it to map value
			displayCategoryScores.put(displaycategoryName, finalscore);
		}
		return displayCategoryScores;
	}

	// --------------------Get Devops Practices Score Map & returms to conent--------------------
	public Map<String, Object> devopsCategoryScore(int assessmentid) {
		Map<String, Object> devopsPracticesScores = new HashMap<>();
		List<String> devopsPracticesNames = helper.devopsPracticesCategoryTabs();

		for (int i = 0; i < devopsPracticesNames.size(); i++) {
			String devopsPracticesName = devopsPracticesNames.get(i);
			int devopsPracticesId = i + 1;
			
			if(devopsPracticesName.equals("Mindset")) {
				continue ;
			}
			
			// Find score for each devops Practices
			String tempscore = questionsresponsesrepo.CalculateScoreByDevOpsPracticesId(assessmentid,devopsPracticesId);
			String maxtempscore = questionmasterRepo.maxScoreByDevopsPracticesId(devopsPracticesId);

			Double score = Double.parseDouble(tempscore);
			Double maxscore = Double.parseDouble(maxtempscore);

			Float finalscore = (float) ((score / maxscore) * 100);
			int recommendedlevelScore = (int) (finalscore / 20);
			int maxPossiblelevel = levelrecommendationsrepo.findMaxRecommendedlevel() ;

			DevopsPracticesObj devopsPracticesCategory = new DevopsPracticesObj();

			devopsPracticesCategory.setScore(finalscore);
			devopsPracticesCategory.setRecommendations(levelrecommendationsrepo.recommendation(devopsPracticesId, recommendedlevelScore));
			devopsPracticesCategory.setCurrentLevel(recommendedlevelScore);
			devopsPracticesCategory.setRecommendedLevel(Math.min(recommendedlevelScore+1,maxPossiblelevel));
			devopsPracticesCategory.setMaxlevel(maxPossiblelevel);

			// Add Score to the devops Practices
			devopsPracticesScores.put(devopsPracticesName, devopsPracticesCategory);
		}
		return devopsPracticesScores;
	}

	
	
}

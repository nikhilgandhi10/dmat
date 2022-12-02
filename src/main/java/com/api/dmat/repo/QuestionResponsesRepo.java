package com.api.dmat.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.dmat.model.QuestionResponses;

public interface QuestionResponsesRepo extends JpaRepository<QuestionResponses, Integer> {

	List<QuestionResponses> findByAssessmentid(int assessmentid);

	QuestionResponses findByAssessmentidAndQuestionid(Integer assessmentid, int questionId);

	// Gets all the question id for a specific displayCategory Id & calculates the
	// sum of scores for those questions
	@Query(value = "select sum(u.score) from QuestionResponses u where u.assessmentid=:assid and u.questionid in( select qu.questionid from QuestionsMaster qu where qu.displaycategoryid=:displayCatid)")
	String CalculateScoreByDisplayCategoryId(@Param("assid") int assid, @Param("displayCatid") int displayCatid);


	// Gets all the questionid for a specific devopsCategory id & calculates the sum
	// of scores for those questions
	@Query(value = "select sum(u.score) from QuestionResponses u where u.assessmentid=:assid and u.questionid in( select qu.questionid from QuestionsMaster qu where qu.devopscategoryid=:devopid)")
	String CalculateScoreByDevOpsPracticesId(@Param("assid") int assid, @Param("devopid") int devopid);

	//checks if entry exists by assessment id 
	boolean existsByAssessmentid(int assessmentId);

}

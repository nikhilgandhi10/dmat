package com.api.dmat.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.dmat.model.ProfileResponses;

public interface ProfileResponsesRepo extends JpaRepository<ProfileResponses, Integer> {

	List<ProfileResponses> findByAssessmentid(int assessmentid);

	ProfileResponses findByAssessmentidAndProfilequestionid(Integer assessmentid, int profileQuestionId);

}

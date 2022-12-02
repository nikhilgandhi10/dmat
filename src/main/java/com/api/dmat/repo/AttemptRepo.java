package com.api.dmat.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.dmat.model.Attempt;

public interface AttemptRepo extends JpaRepository<Attempt, Integer> {

	Attempt findByAssessmentid(int assessmentid);

}

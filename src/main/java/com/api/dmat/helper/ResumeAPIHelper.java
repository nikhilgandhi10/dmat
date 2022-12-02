package com.api.dmat.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.api.dmat.model.Assessment;
import com.api.dmat.model.Attempt;
import com.api.dmat.repo.AssessmentRepo;
import com.api.dmat.repo.AttemptRepo;
import com.api.dmat.utility.ValidationUtility;

enum Status {
	ACTIVE, OBSOLETE
}

@Component
public class ResumeAPIHelper {
	@Autowired
	AttemptRepo attemptrepo;
	@Autowired
	AssessmentRepo assessmentrepo;
	@Autowired
	ValidationUtility utility;

	@Value("#{new Integer('${attemptnumber}')}")
	private int attemptnumber;

	public boolean validator(int assessmentid) {
		return utility.digitChecker(assessmentid) && utility.assessmentIdValidator(assessmentid)
				&& utility.assessmentIdExistsInAttemptsValidator(assessmentid);
	}

	public boolean attemptCheck(int assessmentid) {
		Attempt attempts = attemptrepo.findByAssessmentid(assessmentid);
		if (attempts == null) {
			return false;
		}
		if (attempts.getAttempt() < attemptnumber) {
			attempts.setAttempt(attempts.getAttempt() + 1);
			attemptrepo.save(attempts);
			return true;
		}
		Assessment assessment = assessmentrepo.findByAssessmentid(assessmentid);
		assessment.setStatus(Status.OBSOLETE.toString());
		assessmentrepo.save(assessment);
		return false;

	}
}

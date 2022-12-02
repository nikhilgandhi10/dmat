package com.api.dmat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.dmat.helper.DBHelper;
import com.api.dmat.model.Assessment;
import com.api.dmat.repo.AssessmentRepo;
import com.api.dmat.responses.startAPIResponse.StartAPIContentClass;
import com.api.dmat.utility.GenericUtility;

@Component
public class StartAPIService {

	enum Status {
		ACTIVE,
		COMPLETE,
		OBSOLETE
	}
	
	@Autowired 
	private StartAPIContentClass content ;
	@Autowired
	private DBHelper helper ;
	@Autowired 
	private Assessment assessment ;
	@Autowired
	private AssessmentRepo assessmentrepo ;
	
	// gets the count of assessments already present in the database 
	public int getAssessmentCount() {
		return (int)assessmentrepo.count();
	}

	// get the taba names using the helper class
	public  String getTabNames() {
		return helper.displayCategoryTabs().toString();
	}
	
	// to create an assessment record in the database and return the assessment id to the content class
	public int createAssessment() {
		// gets the starting point of the assessment id numbers 
		int id = helper.getIntialAssessmentId();
		// generates new one using initial id addedd to current entry count in the database 
		int assessmentid = getAssessmentCount()+id ;
		// sets the id and creation date for adding to the database 
		assessment.setAssessmentid(assessmentid);
		//Current Date time using utility function
		assessment.setCreationdatetime(GenericUtility.getCurrentDateTime());
		// sets the current status of the assessment as Active
		assessment.setStatus(Status.ACTIVE.toString());
		// saves the assessment object to the database 
		assessmentrepo.save(assessment);
		// returns the generated assessment id to the content class for display 
		return assessmentid ;
	}
	
	// Service method to create the contetn class and send the response class upon calling 
	public StartAPIContentClass getContent() {
		// sets the tab names and created assessment id for the content clas
		content.setAssessmentID(createAssessment());
		content.setTabs(getTabNames());
		return content;
	}

}

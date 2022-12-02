package com.api.dmat.helper;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.api.dmat.repo.DisplayCategoriesRepo;
import com.api.dmat.utility.DBUtility;
import com.api.dmat.utility.GenericUtility;


@Component
public class DBHelper {
	@Autowired
	DisplayCategoriesRepo displaycategoriesrepo;
	
	@Autowired
	DBUtility utility ;
	
	public DBHelper() {
		//Default Constructor for the Autowired 
	}
	
	//To Generate an 8 digit assessment id for the test using the utility class
	public int getIntialAssessmentId() {
		return GenericUtility.getInitialAssessmentId();
	}

	//To fetch the Tab Category names from the repository using DB utility
	public List<String> displayCategoryTabs() {
		return utility.getDisplayCategoryTabNames() ;
	}

	// Get the generation time for the assessment 
	public java.util.Date getCurrentDateTime() {
		return GenericUtility.getCurrentDateTime();
	}

	public List<String> devopsPracticesCategoryTabs() {
		return utility.getDevopsPracticesNames();
	}

}

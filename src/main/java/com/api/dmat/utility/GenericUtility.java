package com.api.dmat.utility;

import java.util.Date;

import org.springframework.stereotype.Component;

// This Contains the Generic Function and assessment function related to the Application

@Component
public class GenericUtility {
	// starting integer for the assessment id for the application 
	private static int assessmentid = 70000000;

	// returns the starter id 
	public synchronized static int getInitialAssessmentId() {
		return GenericUtility.assessmentid;
	}

	// Returns the current Date time from the system
	public static Date getCurrentDateTime() {
		return new Date(System.currentTimeMillis());
	}
}

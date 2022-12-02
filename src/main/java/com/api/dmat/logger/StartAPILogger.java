package com.api.dmat.logger;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class StartAPILogger {
	
	private static long startTime ;
	private static final Logger LOGGER = LoggerFactory.getLogger(StartAPILogger.class);

	
	// ------------------------------------------ For the generation of assessmentid ------------------------------------------//
	@Before("execution(public * com.api.dmat.controller.StartAPIController.startAssessment())")
	public void creatingAssessmentLogger() {
		StartAPILogger.startTime = System.currentTimeMillis();
		LOGGER.info("Creating Assessment");
	}
	@Before("execution(public * com.api.dmat.helper.DBHelper.getIntialAssessmentId())")
	public void generatingAssessmentIdLogger() {
		LOGGER.info("Generating an 8 digit Assessment id for the user ");
	}
	@After("execution(public * com.api.dmat.helper.DBHelper.getIntialAssessmentId())")
	public void aftergeneratingAssessmentIdLogger() {
		LOGGER.info("8 Digit Assessment Id generated for the User");
		LOGGER.info("Time Taken for Assessment Creation : "+(System.currentTimeMillis() - startTime)+"ms");
	}	
}

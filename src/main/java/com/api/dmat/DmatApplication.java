package com.api.dmat;


import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.api.dmat.controller.SubmitAPIController;
import com.api.dmat.repo.AssessmentRepo;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
//For cron job 
@EnableAsync
@EnableScheduling
// For configs
@Configuration
@EnableWebMvc
@ConfigurationProperties(prefix = "app.api")
public class DmatApplication {
	
	@Value(value = "${version}")
	private String version;
	
	@Value(value = "${title}")
	private String title;
	
	@Value(value = "${description}")
	private String description;

	@Autowired
	private AssessmentRepo assessmentrepo ;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SubmitAPIController.class);

	public static void main(String[] args) {
		SpringApplication.run(DmatApplication.class, args);
	}
	
	 @Bean
	  public InternalResourceViewResolver defaultViewResolver() {
	    return new InternalResourceViewResolver();
	  }
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
			.select().apis(RequestHandlerSelectors.basePackage("com.api.dmat"))
			.paths(PathSelectors.any())
			.build()
			.apiInfo(apiInfo());
	}
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
			.title(title)
			.description(description)
			.version(version)
			.build();
	}
	
	
	
	// Cron Job set to change the status of the databse to obsoet  e every week 
	// Seconds . Minutes . Hours . Day-of-Month . Month . Day-of-Week .  Year(optional field)
	// This runs everyday at 00:00 every 24 hours and checks for 7 days time period of assessment 
	@Scheduled(cron = "0 * */24 * * *")
	public void run() {
		//Logging
	    LOGGER.info("Checking Assessment Status " + Calendar.getInstance().getTime());
	    assessmentrepo.setStatusForAssessments();
	}	
}

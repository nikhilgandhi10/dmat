package com.api.dmat.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.damt.repsonses.downloadreportAPIResponse.DownloadReportAPIResponseClass;
import com.api.dmat.model.Assessment;
import com.api.dmat.model.Users;
import com.api.dmat.repo.AssessmentRepo;
import com.api.dmat.repo.UsersRepo;
import com.api.dmat.service.DownloadReportAPIService;
import com.api.dmat.service.UserExcelExporterService;



@RestController
public class DownloadReportAPIController {
	
	@Autowired
	private DownloadReportAPIService downloadreportapi;
	@Autowired
	private UsersRepo userrepo;
	@Autowired
	private AssessmentRepo assessmentrepo;
	
	
	@GetMapping(value = "/downloadreport", produces = "application/json")
	public ResponseEntity<?> sendReport() throws IOException {
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());
		String fileName = "users_"+ currentDateTime +".xlsx";
		List<Users> listUsers = userrepo.findAll();
		for(Users list : listUsers) {
			System.out.println(list.getBuname()+""+list.getCreatedby()+""+list.getProjectid()+""+list.getProjectname()+""
+list.getUserid());		
			}
		
		@SuppressWarnings("rawtypes")
		List fillentries = downloadreportapi.fillentries();
		UserExcelExporterService excelExporter = new UserExcelExporterService(fillentries); 
		String fileLocation = excelExporter.export();
		System.out.println(fileLocation);
		return ResponseEntity.status(HttpStatus.OK).body(new DownloadReportAPIResponseClass("Successfull Downloading",
						HttpStatus.OK.name() ,HttpStatus.OK.value()));
	}

}

	
	



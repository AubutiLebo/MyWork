package com.dsr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.dsr.model.Report;
import com.dsr.repository.ReportRepository;

@RestController
@RequestMapping("/api")
public class EmployeeController 
{
	@Autowired
	private ReportRepository reportRepo;
	
	  @PostMapping("/employee/addReport")
	    public String addReport(Report reportDetails) throws Exception
	    {	
		  
			  boolean exists = reportRepo.existsBySubmissionDate(reportDetails.getSubmissionDate());
			  if(exists)
			  {
					  
					  return "You have already submitted your report for "+reportDetails.getSubmissionDate();	  
			  }
			  else
			  {
					  reportRepo.save(reportDetails);
					  return "Report saved succesfully";	 
			  }
		  
	    }
		
}

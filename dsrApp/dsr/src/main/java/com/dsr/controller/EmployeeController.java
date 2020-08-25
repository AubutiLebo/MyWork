package com.dsr.controller;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dsr.model.Report;
import com.dsr.repository.ReportRepository;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import java.util.Optional;

@RestController
//@CrossOrigin(origins="http://localhost:8080")
@RequestMapping("/api")
public class EmployeeController 
{
	
	@Autowired private ReportRepository reportRepo;
	/*
	 * @Autowired private EmployeeRepository empTaskRepo;
	 * 
	 * 
	 * @Autowired
	 * 
	 * @PreAuthorize("hasRole('users')")
	 * 
	 * @RequestMapping("/") public String helloWorld() { return "Hello World!"; }
	 * 
	 * 
	 * @GetMapping("/report/{empPSID}/{reportDate}") public Optional<Report>
	 * getReport(@PathVariable ("empPSID")int empPSID, @PathVariable("reportDate")
	 * Date reportDate) { return empTaskRepo.findById(empPSID); }
	 */
	 
   @PostMapping("/report")
	public Report addReport(Report report)
	{
		reportRepo.save(report);
		return report;
	}
   
   @RequestMapping("/report/{empPSID}")
   public Optional<Report> getReport(@PathVariable ("empPSID")int empPSID) 
   { 
   	
	   return reportRepo.findById(empPSID); 
		 
   }
   
}

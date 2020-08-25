package com.dsr.controller;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.dsr.model.Report;
import com.dsr.model.Account;
import com.dsr.model.Project;
import com.dsr.model.ProjectEmployee;
import com.dsr.service.AdminService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class AdminController 
{
	@Autowired
	private AdminService adminService;
	
	
		@PostMapping("/account")
	    public String addAccount(Account accountDetails) 
	    {	        	
	        adminService.createAccount(accountDetails);
	        return "Account Successfully created";
	    }
		
		@PutMapping("/accountupdate")
	    public String updateAccount(Account accountDetails) 
	    {	        
	        adminService.updateAccount(accountDetails);
	        return "Account Successfully updated";
	    }
		
		@DeleteMapping("/account/{accountID}")
	    public String removeAccount(@PathVariable ("accountID")int accountID) 
	    {
	      return adminService.removeAccount(accountID);
	    }
	
		
		
	    @PostMapping("/project")
	    public String addProject(Project projectDetails) 
	    {	        
	        adminService.createProject(projectDetails);
	        return "Project Successfully added";
	    }
	    
	    @PutMapping("/projectupdate")
	    public String updateProject(Project projectDetails) 
	    {	        	
	        adminService.updateProject(projectDetails);
	        return "Project Successfully updated";
	    } 
	    
	    @DeleteMapping("/project/{projectID}")
	    public String removeProject(@PathVariable ("projectID")int projectID) 
	    {
	      return adminService.removeProject(projectID);	      
	    }
	    
	    
	    
	    @PostMapping("/employee")
	    public String addProjectEmployee(ProjectEmployee projectEmployeeDetails) 
	    {	        
	        adminService.addEmployee(projectEmployeeDetails);
	        return "Employee Added successfully";
	    }
	    
	    @PutMapping("/employeeupdate")
	    public String updateProjectEmployee(ProjectEmployee employeeDetails) 
	    {	        	
	        adminService.updateProjectEmployee(employeeDetails);
	        return "Employee Successfully updated";
	    }
	    
	    @DeleteMapping("/employee/{empPSID}")
	    public String removeEmployee(@PathVariable("empPSID") int empPSID) 
	    {
	        return adminService.removeEmployee(empPSID);   
	    }
	    
	    
	    
	    @GetMapping("/report/{empPSID}/{submissionDate}")
	    public List<Report> getReport(@PathVariable ("empPSID")int empPSID, @PathVariable ("submissionDate")Date submissionDate) 
	    {     	
	    	return adminService.getReport(empPSID, submissionDate);	 
	    }  
	    
	    @GetMapping("/reports/{empPSID}/{startDate}/{endDate}")
	    public List<Report> getReportsInRange(@PathVariable ("empPSID")int empPSID, @PathVariable ("startDate")Date startDate, @PathVariable ("endDate")Date endDate) 
	    {     	
	    	return adminService.getReportsInRange(empPSID, startDate, endDate);	 
	    }
	    
	    @GetMapping("/reports/{empPSID}")
	    public List<Report> getReports(@PathVariable("empPSID") int empPSID)
	    { 
	    	return adminService.getReports(empPSID);
	    }
	    
	    @GetMapping("/todaysreports/{todaysDate}")
	    public String getTodaysReports(@PathVariable("todaysDate") Date todaysDate) throws Exception
	    { 
	    	return adminService.getTodaysReports(todaysDate);
	    	
	    }
	    

}

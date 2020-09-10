package com.dsr.controller;
import java.sql.Date;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.dsr.model.Report;
import com.dsr.model.Account;
import com.dsr.model.Employee;
import com.dsr.model.Project;
import com.dsr.model.ProjectEmployee;
import com.dsr.service.AccountServiceImplementation;
import com.dsr.service.EmployeeServiceImplementation;
import com.dsr.service.ProjectEmployeeImplementation;
import com.dsr.service.ProjectServiceImplementation;
import com.dsr.service.ReportServiceImplementation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AdminController 
{
	
	
	@Autowired
	private AccountServiceImplementation accountService;
	@Autowired
	private ProjectServiceImplementation projectService;
	@Autowired
	private ReportServiceImplementation reportService;
	@Autowired
	private ProjectEmployeeImplementation projectEmployeeService;
	@Autowired
	private EmployeeServiceImplementation employeeService;
	
	
//----------------------------Account Manipulation Section---------------------------------------------------	
		
	    //create account method
	    @PostMapping("/admin/createAccount")
	    public String addAccount(Account accountDetails) 
	    {	        	
			accountService.createAccount(accountDetails);
	        return "Account Successfully created";
	    }
		
	    //update account method
		@PutMapping("/admin/updateAccount")
	    public String updateAccount(Account accountDetails) 
	    {	        
			accountService.updateAccount(accountDetails);
	        return "Account Successfully updated";
	    }
		
		//This method deletes an account and it takes the accountID for which you want to delete as a parameter
		@DeleteMapping("/admin/removeAccount/{accountid}")
	    public String removeAccount(@PathVariable ("accountId")int accountId) 
	    {
	      return accountService.removeAccount(accountId);
	    }
		
		//This method gets the list of all accounts in the system
		@GetMapping("/admin/viewAccounts")
	    public List<Account> getAllAccounts() 
	    { 
	    	return accountService.getAllAccounts(); 	
	    }
		
		/*This method gets all the accounts that are under the manager. The manager's emp_id 
		 * is specified in the parameter*/
		@GetMapping("/admin/managerAccounts/{manager_empId}")
	    public List<Account> GetAllAccountsSpecificToManager(@PathVariable ("manager_empId")int managerEmpId) 
	    {
	      return accountService.GetAllAccountsSpecificToManager(managerEmpId);
	    }
		
		
	
//---------------------------------------Project Manipulation Section-----------------------------------------		
		
		
		//This method adds a project to the system under project_master
	    @PostMapping("/admin/project")
	    public String addProject(Project projectDetails) 
	    {	        
	    	projectService.createProject(projectDetails);
	        return "Project Successfully added";
	    }
	    
	    /*This method updates a project. It works the same way as the addProject but if you supply the project_id
	     * that already exists, it updates the project*/
	    @PutMapping("/admin/projectupdate")
	    public String updateProject(Project projectDetails) 
	    {	        	
	    	projectService.updateProject(projectDetails);
	        return "Project Successfully updated";
	    } 
	    
	    //This method removes a project from the system. It takes a project_id as an argument for the project you want to remove.
	    @DeleteMapping("/admin/project/{projectID}")
	    public String removeProject(@PathVariable ("projectID")int projectID) 
	    {
	      return projectService.removeProject(projectID);	      
	    }
	    
	    //This method returns a list of all existing projects in the system.
	    @GetMapping("/admin/projects")
	    public List<Project> getAllProjects() 
	    { 
	    	return projectService.getAllProjects(); 	
	    }
	    
	    /*This method returns a list of all projects under a specific account.
	     * It takes the account_id as an argument for the account you want to search projects for*/
	    @GetMapping("/admin/projects/{accountID}")
	    public List<Project> getAllProjectsForSpecificAccount(@PathVariable ("accountID") int accountID) 
	    { 
	    	return projectService.getAllProjectsForSpecificAccount(accountID); 	
	    }
	    
	    
//--------------------------------------Project Employee Manipulation Section-----------------------------------------	    
	    
	    //This method adds an employee to the account_project_employee_transactional table
	    @PostMapping("/admin/projectemployee")
	    public String addProjectEmployee(ProjectEmployee projectEmployeeDetails) 
	    {	        
	    	projectEmployeeService.addEmployeeToProject(projectEmployeeDetails);
	        return "Employee Added successfully";
	    }
	    
	    /*This method updates an employee in the account_project_employee_transactional table
	     * It works the same as the addProjectEmployee but the only difference is that, it
	     * updates the employee if you supply the same emp_id*/
	    @PutMapping("/admin/projectemployeeupdate")
	    public String updateProjectEmployee(ProjectEmployee employeeDetails) 
	    {	        	
	    	projectEmployeeService.updateProjectEmployee(employeeDetails);
	        return "Employee Successfully updated";
	    }
	    
	    /*This method removes the employee from the account_project_employee_transactional table.
	     * it takes an emp_id as an argument for the employee you want to remove from the project*/
	    @DeleteMapping("/admin/projectemployee/{empId}")
	    public String removeEmployeeFromProject(@PathVariable("empId") int empId) 
	    {
	        return projectEmployeeService.removeEmployeeFromProject(empId);   
	    }
	    
	    //This method returns the list of all employees that are linked to the account_project_employee_transactional table.
	    @GetMapping("/admin/employees")
	    public List<ProjectEmployee> getAllEmployees() 
	    { 
	    	return projectEmployeeService.getAllProjectEmployees(); 	
	    }
	    
	    //This method returns all the employees whose emp_role is "manager".
	    @GetMapping("/admin/managers")
	    public List<Employee> getAllManagers() 
	    { 
	    	return employeeService.getAllManagers(); 	
	    }
	    
	    //This method adds an employee to the employee_master table
	    @PostMapping("/admin/employee")
	    public String addEmployee(Employee employeeDetails) 
	    {	        
	    	return employeeService.addEmployee(employeeDetails);
	        
	    }
	    
	    /*This method removes the employee from the employee_master table.
	     * it takes an emp_id as an argument for the employee you want to remove.*/
	    @DeleteMapping("/admin/employee/{empId}")
	    public String removeEmployee(@PathVariable("empId") int empId) 
	    {
	        return employeeService.removeEmployee(empId);   
	    }
	    
	    /*This method updates an employee in the employee_master table
	     * It works the same as the addEmployee but the only difference is that, it
	     * updates the employee if you supply the same emp_id*/
	    @PutMapping("/admin/employeeupdate")
	    public String updateEmployee(Employee employeeDetails) 
	    {	        	
	    	return employeeService.addEmployee(employeeDetails);
	       
	    }
	    
//----------------------------------------Report Manipulation Section------------------------------------------	    
	    
	    /*This method returns a report for the specific employee which was submitted on a specific date.
	     * it takes an emp_id of the employee for which you want to retrieve a report for as well as the
	     * the date you want to view a report for. It returns a single report*/
	    @GetMapping("/admin/report/{empId}/{submissionDate}")
	    public List<Report> getReport(@PathVariable ("empId")int empId, @PathVariable ("submissionDate")Date submissionDate) 
	    {     	
	    	return reportService.getReport(empId, submissionDate);	 
	    }  
	    
	    /*This method returns a list of reports within a range of specified dates for the specified employee.
	     * It takes an emp_id for which you want to check reports for as well as the start date and the end date
	     * for which you want to create a range between*/
	    @GetMapping("/admin/reports/{empId}/{startDate}/{endDate}")
	    public List<Report> getReportsInRangeForSpecificEmployee(@PathVariable ("empId")int empId, @PathVariable ("startDate")Date startDate, @PathVariable ("endDate")Date endDate) 
	    {     	
	    	return reportService.getReportsInRangeForSpecificEmployee(empId, startDate, endDate);	 
	    }
	    
	    /*This method returns a list of all the reports for a specific employee
	     * It takes emp_id of the employee you want to return a list of all reports for*/
	    @GetMapping("/admin/reports/{empId}")
	    public List<Report> getReportsForSpecificEmployee(@PathVariable("empId") int empId)
	    { 
	    	return reportService.getReportsForSpecificEmployee(empId);
	    }
	    
	    /*This method returns a list of all the reports that were submitted today.
	     * The manager is able to extract a PDF document that contains all the reports for today.
	     * It takes today's date as an argument from the front end*/
	    @GetMapping("/admin/report/{todaysDate}")
	    public String getTodaysReports(@PathVariable("todaysDate") Date todaysDate) throws Exception
	    { 
	    	return reportService.getTodaysReports(todaysDate);	
	    }
	    
	    /*This method returns a list of all reports for today that were submitted under a specific project.
	     * It takes project_id and today's date as an argument*/
	    @GetMapping("/admin/report/{projectID}/{todaysDate}")
	    public List<Report> getTodaysReportsForSpecificProject(@PathVariable("projectID") int projectID,@PathVariable("todaysDate") Date todaysDate)
	    { 
	    	return reportService.getTodaysReportsForSpecificProject(projectID,todaysDate);	
	    }
	    
		/*
		 * @GetMapping("/report/{empID}/{searchDate}") public List
		 * getReportByDate(@PathVariable("empID") int empID, @PathVariable("searchDate")
		 * Date date) throws Exception { return reportService.getReportByDate(empID,
		 * date); }
		 */
}

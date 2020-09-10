package com.dsr.service;

import java.sql.Date;
import java.util.List;

import com.dsr.model.Report;

public interface ReportService 
{
	//This method gets a report for the specific employee for a specific date
	public List<Report> getReport(int empId, Date submissionDate);
	//This method gets a list of reports in range between two dates for the specific employee
	public List<Report> getReportsInRangeForSpecificEmployee(int empId, Date startDate, Date endDate);
	//This method gets a list of reports for the specific employee
	public List<Report> getReportsForSpecificEmployee(int empId);
	//This method extracts a PDF file populated with a list of employees and their reports for the day
	public String getTodaysReports(Date todaysDate) throws Exception; 
	//This method gets reports for today for a specific project
	public List<Report> getTodaysReportsForSpecificProject(int projectID, Date todaysDate); 

}

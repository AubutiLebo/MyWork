package com.dsr.service;

import java.io.FileOutputStream;
import java.sql.Date;
import java.util.List;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsr.model.Report;
import com.dsr.model.Account;
import com.dsr.model.Employee;
import com.dsr.model.Project;
import com.dsr.model.ProjectEmployee;
import com.dsr.repository.ProjectRepository;
import com.dsr.repository.ReportRepository;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import com.dsr.repository.ProjectEmployeeRepository;
import com.dsr.repository.AccountRepository;


@Service
public class AdminService 
{
	private Employee employeeRepo;
	
	 @Autowired
	 private ProjectRepository projectRepo;
	 
	 @Autowired
	 private AccountRepository accountRepo;
	 
	 @Autowired
	 private ReportRepository reportRepo;
	 
	 @Autowired
	 private ProjectEmployeeRepository projectEmpRepo;
	 
	 public void createAccount(Account accountDetails)
	 {
			
		 accountRepo.save(accountDetails);
		
	 }

	 public String removeAccount(int accountID) 
	 {
		 try
		 {
			 accountRepo.deleteById(accountID);
		    return "Account " + accountID + " Removed Successfully";
		 }
		 catch(Exception e)
		 {
			 return "Account " + accountID + " not found";
		 }
	   	
	 }
	 
	 public void createProject(Project projectDetails)
	 {
		
		 projectRepo.save(projectDetails);
	 }
	 
	 public String removeProject(int projectID)
	 {
		 try
		 {
		    projectRepo.deleteById(projectID);
		    return "Project " + projectID + "Removed Successfully";
		 }
		 catch(Exception e)
		 {
			 return "Project " + projectID + " not found";
		 }
	 }
	 
	 
	
	 public List<Report> getReport(int empPSID, Date submissionDate)
	 {
		 return reportRepo.findByEmpPSID(empPSID, submissionDate); 
	 }
	 
	 public List<Report> getReports(int empPSID) 
	 {
		 return reportRepo.findByEmpPSID(empPSID);
	 }

	 public void addEmployee(ProjectEmployee projectEmployeeDetails)
	 {
		 projectEmpRepo.save(projectEmployeeDetails);
     }

	 public String removeEmployee(int empPSID) 
	 {
		  try
		  {
		 	 projectRepo.deleteById(empPSID);
		     return "Project " + empPSID + "Removed Successfully";
		  }
		  catch(Exception e)
		  {
			 return "Employee " + empPSID + " not found";
		  }
		
		
	}

	public List<Report> getReportsInRange(int empPSID, Date startDate, Date endDate) 
	{
		
		return reportRepo.findByEmpPSID(empPSID, startDate, endDate);

	}

	public void updateAccount(Account accountDetails) 
	{
		accountRepo.save(accountDetails);
		
	}

	public void updateProject(Project projectDetails) 
	{
		projectRepo.save(projectDetails);
		
		
	}

	public void updateProjectEmployee(ProjectEmployee employeeDetails)
	{
		projectEmpRepo.save(employeeDetails);
		
	}

	public String getTodaysReports(Date todaysDate) throws Exception
	{
		List<Report> reportList = reportRepo.findBySubmissionDate(todaysDate);
		
		Document document = new Document(PageSize.A4);
		/*
		 * Please change the file location to the one in your computer. If you don't want
		 * to specify the location, you can always save the file as just "dsr.pdf"
		 * instead of "C:\\Users\\Aubuti Lebo\\Documents\\dsr.pdf""
		 */		
		String fileLocation = "C:\\Users\\Aubuti Lebo\\Documents\\dsr.pdf";
		PdfWriter.getInstance(document, new FileOutputStream(fileLocation));
		document.open();
		document.add(new Paragraph("List of DSRs for : "+todaysDate));
			
		PdfPTable table = new PdfPTable(5);
		table.setWidthPercentage(100);
	    table.setSpacingBefore(15);
		
		addTableHeader(table);
		addRows(table, reportList); 
		document.add(table);
		document.close();
		//Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + fileLocation);
		
		
		
		return "file successfully extracted and saved at : " + fileLocation;	
	}

	private void addTableHeader(PdfPTable table) 
	{
		 Stream.of("Employee PSID","Employee name", "Task Completed", "Task planned for tommorow", "Issues faced")
	      .forEach(columnTitle -> 
	      {
	        PdfPCell header = new PdfPCell();
	        header.setBackgroundColor(BaseColor.LIGHT_GRAY);
	        
	        header.setPhrase(new Phrase(columnTitle));
	        table.addCell(header);
	      }
	    );	
	}
	private void addRows(PdfPTable table, List<Report> reportList) throws Exception 
	{	
		for(int i = 0 ; i < reportList.size(); i++)
		{
			table.addCell(Integer.toString(reportList.get(i).getEmpPSID()));
			table.addCell("No model for Employee");
			table.addCell(reportList.get(i).getTask_completed());
			table.addCell(reportList.get(i).getTask_planned());
			table.addCell(reportList.get(i).getTask_issues());	
		}
	 
	}


	

	
	
	
}

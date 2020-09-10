package com.dsr.service;

import java.io.FileOutputStream;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsr.model.Employee;
import com.dsr.model.Report;
import com.dsr.repository.EmployeeRepository;
import com.dsr.repository.ReportRepository;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class ReportServiceImplementation implements ReportService
{
	@Autowired
	private EmployeeRepository empRepo;
	
	 @Autowired
	 private ReportRepository reportRepo;
	
	@Override
	public List<Report> getReport(int empId, Date submissionDate)
	{
	    return reportRepo.findByEmpId(empId, submissionDate); 
    }
	@Override
	public List<Report> getReportsInRangeForSpecificEmployee(int empId, Date startDate, Date endDate) 
	{
		return reportRepo.findByEmpId(empId, startDate, endDate);
	}
	@Override
	public List<Report> getReportsForSpecificEmployee(int empId) 
	{
		return reportRepo.findByEmpId(empId);
    }
	@Override
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
		 Stream.of("Employee ID","Employee name", "Task Completed", "Task planned for tommorow", "Issues faced")
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
			
			table.addCell(Integer.toString(reportList.get(i).getEmpId()));
		    String employeeName = empRepo.findByEmpId(reportList.get(i).getEmpId());
			table.addCell(employeeName);
			table.addCell(reportList.get(i).getTask_completed());
			table.addCell(reportList.get(i).getTask_planned());
			table.addCell(reportList.get(i).getTask_issues());	
		}
	 
	}
	@Override
	public List<Report> getTodaysReportsForSpecificProject(int projectID, Date todaysDate) 
	{
		return reportRepo.findByProjectId(projectID, todaysDate);
	}
	
	
	/*
	 * public List getReportByDate(int empID, Date searchDate) throws Exception {
	 * 
	 * SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd",
	 * Locale.ENGLISH); LocalDateTime currentDate = LocalDateTime.now();
	 * 
	 * java.util.Date firstDate = dateFormatter.parse(searchDate.toString());
	 * 
	 * java.util.Date secondDate = dateFormatter.parse(currentDate.toString());
	 * 
	 * long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
	 * long difference = TimeUnit.DAYS.convert(diffInMillies,
	 * TimeUnit.MILLISECONDS);
	 * 
	 * if(difference > 31) { List<String> message = new ArrayList<>();
	 * message.add("You cannot view a report older than a month"); return message; }
	 * else { return reportRepo.findByEmpId(empID, searchDate); }
	 * 
	 * }
	 */
}

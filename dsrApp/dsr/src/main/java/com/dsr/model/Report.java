package com.dsr.model;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Entity
@Component
@Table(name  = "report_transactional")
public class Report
{
	
	@Id
	@Column(name = "emp_psid")
	private int empPSID;
	private int project_id;
	private int account_id;
	private String task_completed;
	private String task_planned;
	private String task_issues;
	@Column(name = "submission_date")
	private Date submissionDate;
	
	
	
	public Date getSubmissionDate() 
	{
		return submissionDate;
	}
	public void setSubmissionDate(Date submissionDate) 
	{
		this.submissionDate = submissionDate;
	}

	public int getEmpPSID() {
		return empPSID;
	}
	public void setEmpPSID(int empPSID) {
		this.empPSID = empPSID;
	}
	public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
	public int getAccount_id() {
		return account_id;
	}
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	public String getTask_completed()
	{
		return task_completed;
	}
	public void setTask_completed(String task_completed) 
	{
		this.task_completed = task_completed;
	}
	public String getTask_planned() 
	{
		return task_planned;
	}
	public void setTask_planned(String task_planned) 
	{
		this.task_planned = task_planned;
	}
	public String getTask_issues() 
	{
		return task_issues;
	}
	public void setTask_issues(String task_issues) 
	{
		this.task_issues = task_issues;
	}
	
	
	
}

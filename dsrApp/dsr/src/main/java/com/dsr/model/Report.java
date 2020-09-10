package com.dsr.model;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Entity
@Component
@Table(name  = "report_transactional")
public class Report
{
	
	
	@Column(name = "emp_id")
	private int empId;
	@Column(name = "project_id")
	private int projectId;
	
	private int account_id;
	private String task_completed;
	private String task_planned;
	private String task_issues;
	@Id
	@Column(name = "submission_date")
	private Date submissionDate;
	
	public int getProjectId() 
	{
		return projectId;
	}
	public void setProjectId(int projectId) 
	{
		this.projectId = projectId;
	}
	
	
	public Date getSubmissionDate() 
	{
		return submissionDate;
	}
	public void setSubmissionDate(Date submissionDate) 
	{
		this.submissionDate = submissionDate;
	}

	public int getEmpId() 
	{
		return empId;
	}
	public void setEmpId(int empId)
	{
		this.empId = empId;
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

package com.dsr.model;

import javax.persistence.Column;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "project_master")
public class Project 


{
	@Id
	@Column(name = "project_id")
	private int projectId;
	@Column(name = "account_id")
	private int accountId;
	private String reporting_manager;
	private String project_desc;
	private String created_by;
	private Date created_on;
	private byte deleted;
	private String modified_by;
	private Date modified_on;
	
	public String getCreated_by() 
	{
		return created_by;
	}
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
	public Date getCreated_on() {
		return created_on;
	}
	public void setCreated_on(Date created_on) {
		this.created_on = created_on;
	}
	public byte getDeleted() {
		return deleted;
	}
	public void setDeleted(byte deleted) {
		this.deleted = deleted;
	}
	public String getModified_by() {
		return modified_by;
	}
	public void setModified_by(String modified_by) {
		this.modified_by = modified_by;
	}
	public Date getModified_on() {
		return modified_on;
	}
	public void setModified_on(Date modified_on) {
		this.modified_on = modified_on;
	}
	
	
	public int getAccountId() 
	{
		return accountId;
	}
	public void setAccountId(int accountId) 
	{
		this.accountId = accountId;
	}

	
	
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getReporting_manager() {
		return reporting_manager;
	}
	public void setReporting_manager(String reporting_manager) {
		this.reporting_manager = reporting_manager;
	}
	public String getProject_desc() {
		return project_desc;
	}
	public void setProject_desc(String project_desc) {
		this.project_desc = project_desc;
	}
	
	
	
	
}

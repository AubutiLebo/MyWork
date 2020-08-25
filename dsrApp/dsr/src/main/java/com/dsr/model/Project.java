package com.dsr.model;

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
	private int project_id;
	private int account_id;
	private String reporting_manager;
	private String project_desc;
	
	
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

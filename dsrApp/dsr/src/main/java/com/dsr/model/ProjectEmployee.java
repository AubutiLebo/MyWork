package com.dsr.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "account_project_employee_transactional")
public class ProjectEmployee 
{
	
    @Id
	private int emp_psid;
	
	private int project_id;
	
	private int account_id;
	
	public int getProject_id() 
	{
		return project_id;
	}
	public void setProject_id(int project_id) 
	{
		this.project_id = project_id;
	}
	public int getAccount_id() {
		return account_id;
	}
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	public int getEmp_psid() {
		return emp_psid;
	}
	public void setEmp_psid(int emp_psid) {
		this.emp_psid = emp_psid;
	}
	
	
	
}

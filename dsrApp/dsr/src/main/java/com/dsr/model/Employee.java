package com.dsr.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Entity
@Component
@Table(name = "employee_master")
public class Employee 
{
	@Id
	private int emp_psid;
	private String emp_name;
	
	public int getEmp_psid() 
	{
		return emp_psid;
	}
	public void setEmp_psid(int emp_psid) 
	{
		this.emp_psid = emp_psid;
	}
	public String getEmp_name()
	{
		return emp_name;
	}
	public void setEmp_name(String emp_name) 
	{
		this.emp_name = emp_name;
	}
}

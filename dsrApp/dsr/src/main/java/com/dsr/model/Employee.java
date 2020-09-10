package com.dsr.model;


import java.sql.Date;

import javax.persistence.Column;
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
	@Column(name = "emp_id")
	private int empId;
	private int emp_psid;
	private String emp_name;
	@Column(name = "emp_role")
	private String empRole;
	private String emp_email;
	private String created_by;
	private Date created_on;
	private byte deleted;
	private String modified_by;
	private Date modified_on;
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpRole() {
		return empRole;
	}
	public void setEmpRole(String empRole) {
		this.empRole = empRole;
	}
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
	
	
	public String getEmp_email() {
		return emp_email;
	}
	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}
	
	
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

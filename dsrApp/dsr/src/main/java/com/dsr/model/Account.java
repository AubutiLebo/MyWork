package com.dsr.model;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "account_master")
public class Account 
{
	@Id
    private int account_id;
	@Column(name = "reporting_manager")
	private int empId;
    private String account_desc;
    private String created_by;
    private Date created_on;
    private byte deleted;
    private String modified_by;
    private Date modified_on;
    
    
   
	public String getCreated_by() {
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
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public int getAccount_id() 
	{
		return account_id;
	}
	public void setAccount_id(int account_id) 
	{
		this.account_id = account_id;
	}
    
	public String getAccount_desc() 
	{
		return account_desc;
	}
	public void setAccount_desc(String account_desc) 
	{
		this.account_desc = account_desc;
	}
	
	
	
}

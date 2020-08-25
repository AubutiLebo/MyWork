package com.dsr.model;

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
	private String reporting_manager;
    private String account_desc;
   
	public int getAccount_id() 
	{
		return account_id;
	}
	public void setAccount_id(int account_id) 
	{
		this.account_id = account_id;
	}

   
    public String getReporting_manager()
    {
		return reporting_manager;
	}
	public void setReporting_manager(String reporting_manager) {
		this.reporting_manager = reporting_manager;
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

package com.dsr.service;

import java.util.List;

import com.dsr.model.Account;

public interface AccountService 
{
	//This method creates an account and saves it to the system
	public void createAccount(Account accountDetails);
	//This method updates an account in the system
	public void updateAccount(Account accountDetails);
	//this method removes an account from the system
	public String removeAccount(int accountID); 
	//This method gets a list of all accounts in the system
	public List<Account> getAllAccounts();
	//This method gets a list of all accounts specific to a manager
	public List<Account> GetAllAccountsSpecificToManager(int managerEmpID); 

}

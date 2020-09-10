package com.dsr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsr.model.Account;
import com.dsr.repository.AccountRepository;

@Service
public class AccountServiceImplementation implements AccountService
{
	 @Autowired
	 private AccountRepository accountRepo;
	
	 @Override
	 public void createAccount(Account accountDetails)
	 {		
		 accountRepo.save(accountDetails);
	 }
	 @Override
	 public void updateAccount(Account accountDetails) 
	 {
	   	 accountRepo.save(accountDetails);
			
	 }
	 @Override
	 public String removeAccount(int accountID) 
	 {
		 try
		 {
			 accountRepo.deleteById(accountID);
		    return "Account " + accountID + " Removed Successfully";
		 }
		 catch(Exception e)
		 {
			 return "Account " + accountID + " not found";
		 }
	   	
	 }
	 @Override
	 public List<Account> getAllAccounts()
	 {
		 return accountRepo.findAll();
	 }
	public List<Account> GetAllAccountsSpecificToManager(int managerEmpID) 
	{
		return accountRepo.findByEmpId(managerEmpID);
		
	}
}

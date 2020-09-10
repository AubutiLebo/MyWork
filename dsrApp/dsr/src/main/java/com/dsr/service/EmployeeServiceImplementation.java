package com.dsr.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsr.model.Employee;
import com.dsr.model.ProjectEmployee;
import com.dsr.repository.EmployeeRepository;

@Service
public class EmployeeServiceImplementation implements EmployeeService
{
	 @Autowired
	 private EmployeeRepository employeeRepo;
    
    @Override
	public List<Employee> getAllManagers() 
	{
		return employeeRepo.findByEmpRole("manager");
	}
    
    @Override
    public String addEmployee(Employee employeeDetails)
    {
    	try 
    	{
    		employeeRepo.save(employeeDetails);
    		return "Employee added successfully";
    	}
    	catch(Exception e)
    	{
    		return "Error adding employee. \nMake sure all the details are supplied and with matching data types";
    	}
    }

    @Override
	 public String removeEmployee(int empId) 
	 {
		  try
		  {
		 	 employeeRepo.deleteById(empId);
		     return "Employee " + empId + "Removed Successfully";
		  }
		  catch(Exception e)
		  {
			 return "Employee " + empId + " not found";
		  }		
	  }

    @Override
	 public String updateEmployee(Employee employeeDetails)
	 {
    	try
    	{
    		
    		employeeRepo.save(employeeDetails);
    		return "Employee successfully updated";
    	}
    	catch(Exception e)
    	{
    		return "Error updating employee.\n Make sure you supply all details as required with appropriate data types";
    	}
		  
			
	 }
	 

}

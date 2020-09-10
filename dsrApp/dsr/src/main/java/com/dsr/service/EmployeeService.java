package com.dsr.service;

import java.util.List;

import com.dsr.model.Employee;

public interface EmployeeService 
{
	public List<Employee> getAllManagers();

	public String addEmployee(Employee employeeDetails);

	public String removeEmployee(int empId);

	public String updateEmployee(Employee employeeDetails);
}

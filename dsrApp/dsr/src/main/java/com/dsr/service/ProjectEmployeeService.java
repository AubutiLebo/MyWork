package com.dsr.service;

import java.util.List;

import com.dsr.model.Employee;
import com.dsr.model.ProjectEmployee;

public interface ProjectEmployeeService 
{
	//This method adds an employee to the project
	public void addEmployeeToProject(ProjectEmployee projectEmployeeDetails);
	//This method updates employee in the project i.e. not an employee but an employee in a project
	public void updateProjectEmployee(ProjectEmployee employeeDetails);
	//This method removes an employee from a project and returns a result string message
	public String removeEmployeeFromProject(int empPSID);
	//This method gets a list of all Employees in the Project
	public List<ProjectEmployee> getAllProjectEmployees();

}

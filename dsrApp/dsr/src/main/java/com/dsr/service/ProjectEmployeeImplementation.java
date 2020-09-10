package com.dsr.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dsr.model.ProjectEmployee;
import com.dsr.repository.ProjectEmployeeRepository;
import com.dsr.repository.ProjectRepository;

@Service
public class ProjectEmployeeImplementation implements ProjectEmployeeService
{
	 @Autowired
	 private ProjectEmployeeRepository projectEmpRepo;
	 @Autowired
	 private ProjectRepository projectRepo;
	 
	 @Override
	 public void addEmployeeToProject(ProjectEmployee projectEmployeeDetails)
	 {
		 projectEmpRepo.save(projectEmployeeDetails);
     }
	 @Override
	 public void updateProjectEmployee(ProjectEmployee employeeDetails)
	 {
		  projectEmpRepo.save(employeeDetails);
			
	 }
	 @Override
	 public String removeEmployeeFromProject(int empId) 
	 {
		  try
		  {
		 	 projectRepo.deleteById(empId);
		     return "Employee " + empId + "Removed Successfully from project";
		  }
		  catch(Exception e)
		  {
			 return "Employee " + empId + " not found";
		  }		
	  }
	 @Override
	  public List<ProjectEmployee> getAllProjectEmployees()
	  {
			
			return projectEmpRepo.findAll();
	  }

	
}

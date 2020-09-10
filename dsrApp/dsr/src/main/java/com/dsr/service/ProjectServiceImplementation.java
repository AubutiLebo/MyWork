package com.dsr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsr.model.Project;
import com.dsr.repository.ProjectRepository;

@Service
public class ProjectServiceImplementation implements ProjectService
{
	 @Autowired
	 private ProjectRepository projectRepo;
	 
	 @Override
	 public void createProject(Project projectDetails)
	 {
		 projectRepo.save(projectDetails);
	 }
	 @Override
	 public void updateProject(Project projectDetails) 
	 {
		 projectRepo.save(projectDetails);			
	 }
	 @Override
	 public String removeProject(int projectID)
	 {
		 try
		 {
		    projectRepo.deleteById(projectID);
		    return "Project " + projectID + "Removed Successfully";
		 }
		 catch(Exception e)
		 {
			 return "Project " + projectID + " not found";
		 }
	 }
	 @Override
	 public List<Project> getAllProjects() 
	 {
		 return projectRepo.findAll();
	 }
	@Override
	public List<Project> getAllProjectsForSpecificAccount(int accountID) 
	{
		return projectRepo.findByAccountId(accountID);
		
	}
}

package com.dsr.service;

import java.util.List;

import com.dsr.model.Project;

public interface ProjectService 
{
	 //This method creates a project
	 public void createProject(Project projectDetails);
	 //This method updates a project
	 public void updateProject(Project projectDetails);
	 //This method removes a project from the System
	 public String removeProject(int projectID);
	 //This method gets a list of all projects in the System 
	 public List<Project> getAllProjects(); 
	 //This Method gets a list of projects under a specific Account
	 public List<Project> getAllProjectsForSpecificAccount(int accountID);
}

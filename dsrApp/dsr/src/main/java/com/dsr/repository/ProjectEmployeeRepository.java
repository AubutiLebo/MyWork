package com.dsr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dsr.model.ProjectEmployee;

public interface ProjectEmployeeRepository extends JpaRepository<ProjectEmployee, Integer>
{
	
}

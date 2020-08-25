package com.dsr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dsr.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee , Integer>
{

}

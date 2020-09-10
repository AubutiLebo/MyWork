package com.dsr.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dsr.model.Employee;
import com.dsr.model.Report;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee , Integer>
{
	List<Employee> findByEmpRole(String empRole);
	
	@Query("SELECT emp_name FROM Employee WHERE emp_id=?1")
	String findByEmpId(int empId);	
}

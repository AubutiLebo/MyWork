package com.dsr.repository;


import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dsr.model.Report;


@Repository
public interface ReportRepository extends JpaRepository <Report, Integer>
{
	
    @Query("FROM Report WHERE emp_id=?1 and submission_date=?2")
	List<Report> findByEmpId(int emp_id, Date submission_date);

    @Query("FROM Report WHERE emp_id=?1 AND submission_date BETWEEN ?2 AND ?3")
	List<Report> findByEmpId(int emp_id, Date startDate, Date endDate);
    
    List<Report> findByEmpId(int emp_id);
    
	List<Report> findBySubmissionDate(Date todaysDate);
	
	@Query("FROM Report WHERE projectId=?1 and submission_date=?2")
	List<Report> findByProjectId(int projectID, Date todaysDate);
	 
	boolean existsBySubmissionDate(Date date);
}

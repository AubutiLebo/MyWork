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
    @Query("FROM Report WHERE emp_psid=?1 and submission_date=?2")
	List<Report> findByEmpPSID(int emp_psid, Date submission_date);
    
    @Query("FROM Report WHERE emp_psid=?1 AND submission_date BETWEEN ?2 AND ?3")
	List<Report> findByEmpPSID(int emp_psid, Date startDate, Date endDate);
    
    List<Report> findByEmpPSID(int emp_psid);
    
	List<Report> findBySubmissionDate(Date todaysDate);
}

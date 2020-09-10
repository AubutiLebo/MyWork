package com.dsr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dsr.model.Account;

public interface AccountRepository extends JpaRepository <Account, Integer>
{

	List<Account> findByEmpId(int managerEmpID);
}

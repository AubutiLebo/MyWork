package com.dsr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dsr.model.Account;
import com.dsr.model.Project;

public interface AccountRepository extends JpaRepository <Account, Integer>
{

}

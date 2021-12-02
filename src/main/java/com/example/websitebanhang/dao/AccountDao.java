package com.example.websitebanhang.dao;

import java.util.List;

import com.example.websitebanhang.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface AccountDao extends JpaRepository<Account, String> {
    @Query("SELECT DISTINCT ar.account From Authority ar WHERE ar.role.id IN ('DIRE','STAF')")
	List<Account> getAdministrator();

}

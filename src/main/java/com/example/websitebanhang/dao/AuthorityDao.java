package com.example.websitebanhang.dao;

import java.util.List;

import com.example.websitebanhang.entity.Account;
import com.example.websitebanhang.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface AuthorityDao extends JpaRepository<Authority,Integer> {
	@Query("SELECT DISTINCT a FROM Authority a WHERE a.account IN ?1")
	List<Authority> authoritiesOf(List<Account> ac);

}

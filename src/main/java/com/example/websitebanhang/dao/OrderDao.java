package com.example.websitebanhang.dao;

import java.util.List;

import com.example.websitebanhang.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface OrderDao extends JpaRepository<Order, Long>{
	@Query("SELECT o FROM Order o Where o.account.username=?1")
	List<Order> findByUsername(String username);

}

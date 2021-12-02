package com.example.websitebanhang.dao;

import com.example.websitebanhang.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderDetailDao extends JpaRepository<OrderDetail,Long> {

}

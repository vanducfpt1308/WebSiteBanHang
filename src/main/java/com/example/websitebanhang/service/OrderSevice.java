package com.example.websitebanhang.service;

import java.util.List;

import com.example.websitebanhang.entity.Order;
import com.fasterxml.jackson.databind.JsonNode;


public interface OrderSevice {
	
	Order create(JsonNode orderData);

	Order findById(Long id);

	List<Order> findByUsername(String username);

}

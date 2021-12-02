package com.example.websitebanhang.service.lmpl;

import java.util.List;
import java.util.stream.Collectors;

import com.example.websitebanhang.dao.OrderDao;
import com.example.websitebanhang.dao.OrderDetailDao;
import com.example.websitebanhang.entity.Order;
import com.example.websitebanhang.entity.OrderDetail;
import com.example.websitebanhang.service.OrderSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class OrderSeviceImpI implements OrderSevice {
	@Autowired
	OrderDao dao;
	
	@Autowired
	OrderDetailDao ddao;

	@Override
	public Order create(JsonNode orderData) {
		ObjectMapper mapper = new ObjectMapper();
		Order order = mapper.convertValue(orderData, Order.class);
		dao.save(order);
		
		TypeReference<List<OrderDetail>> type = new TypeReference<List<OrderDetail>>() {};
		List<OrderDetail> details = mapper.convertValue(orderData.get("orderDetails"), type)
				.stream().peek(d->d.setOrder(order)).collect(Collectors.toList());
		ddao.saveAll(details);
		
		return order;
	}

	@Override
	public Order findById(Long id) {
		
		return dao.findById(id).get();
	}

	@Override
	public List<Order> findByUsername(String username) {
	
		return dao.findByUsername(username);
	}
	

}

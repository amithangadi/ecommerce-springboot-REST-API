package com.ecommerce.ecommerceproject.service;

import java.util.List;

import com.ecommerce.ecommerceproject.entity.Order;

public interface OrderService {

	Order placeOrder(Order order);
	
	List<Order> getAllOrders();
	
	List<Order> getOrderByUser(Long userId);
	
	Order updateStatus(Long id, String status);
}

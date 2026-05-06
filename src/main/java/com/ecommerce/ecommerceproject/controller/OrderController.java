package com.ecommerce.ecommerceproject.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.ecommerce.ecommerceproject.entity.Order;
import com.ecommerce.ecommerceproject.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

	private final OrderService orderService;
	
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@PostMapping
	public Order place(@RequestBody Order order) {
		 return orderService.placeOrder(order);
	}
	
	@GetMapping
	public List<Order> all() {
		return orderService.getAllOrders();
	}
	
	@GetMapping("/user/{userId}")
	public List<Order> byUser(@PathVariable Long userId) {
		return orderService.getOrderByUser(userId);
	}
	
	@PutExchange("/{id}")
	public Order update(@PathVariable Long id, @RequestParam String status) {
		return orderService.updateStatus(id, status);
	}
}

package com.ecommerce.ecommerceproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.ecommerceproject.entity.Order;
import com.ecommerce.ecommerceproject.entity.Product;
import com.ecommerce.ecommerceproject.repository.OrderRepository;
import com.ecommerce.ecommerceproject.repository.ProductRepository;

@Service
public class OrderServiceImpl implements OrderService{

	private final OrderRepository orderRepository;
	private final ProductRepository productRepository;
	
	public OrderServiceImpl(OrderRepository orderRepository, ProductRepository productRepository) {
		this.orderRepository = orderRepository;
		this.productRepository = productRepository;
	}
	
	
	@Override
	public Order placeOrder(Order order) {
		Product product = productRepository
				.findById(order.getProduct().getId())
				.orElseThrow(() ->
							new RuntimeException("Product not found"));
		
		order.setTotalPrice(
				product.getPrice()
				  		*order.getQuantity()
			);
		
		order.setStatus("Placed");
		
		return orderRepository.save(order);
	}
	
	
	@Override
	public List<Order> getAllOrders() {

	return orderRepository.findAll();
	}
	
	
	@Override
	public List<Order> getOrderByUser(Long userId) {
		
		return orderRepository.findByUserId(userId);
	}
	
	
	@Override
	public Order updateStatus(Long id, String status) {
		
		Order order = orderRepository
				.findById(id)
				.orElseThrow(() -> 
				new RuntimeException("Order not found"));
		
		order.setStatus(status);
		
		return orderRepository.save(order);
	}
	
	
}

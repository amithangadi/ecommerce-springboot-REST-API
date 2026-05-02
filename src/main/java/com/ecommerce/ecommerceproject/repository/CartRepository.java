package com.ecommerce.ecommerceproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.ecommerceproject.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>{

	List<Cart> findByUserId(Long userId);

	void deleteByUserId(Long userId);
	
}

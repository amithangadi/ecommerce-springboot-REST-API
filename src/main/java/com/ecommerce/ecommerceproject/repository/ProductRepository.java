package com.ecommerce.ecommerceproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.ecommerceproject.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	List<Product> findByNameContainingIgnoreCase(String name);
	
	List<Product> findByCategoryId(Long categoryId);
}

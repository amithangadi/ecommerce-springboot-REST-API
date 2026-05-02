package com.ecommerce.ecommerceproject.service;

import java.util.List;

import com.ecommerce.ecommerceproject.entity.Review;

public interface ReviewService {

	Review add(Review review);
	
	List<Review> getByProduct(Long productId);
	
	void delete(Long id);
	
	Double average(Long productId);
}

//to achieve abstraction we create an interface in service 

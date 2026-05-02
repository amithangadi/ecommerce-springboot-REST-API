package com.ecommerce.ecommerceproject.service;

import java.util.List;

import com.ecommerce.ecommerceproject.entity.Cart;

public interface CartService {

	Cart addToCart(Cart cart);
	
	List<Cart> getUserCart(Long userId);
	
	void removeItem(Long cartId);
	
	void clearCart(Long userId);
}

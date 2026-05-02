package com.ecommerce.ecommerceproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.ecommerceproject.entity.Cart;
import com.ecommerce.ecommerceproject.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService{

	private final CartRepository cartRepository;
	
	public CartServiceImpl(CartRepository cartRepository) {
		this.cartRepository = cartRepository;
	}
	
	@Override
	public Cart addToCart(Cart cart) {
		// TODO Auto-generated method stub
		return cartRepository.save(cart);
	}

	@Override
	public List<Cart> getUserCart(Long userId) {
		// TODO Auto-generated method stub
		return cartRepository.findByUserId(userId);
	}

	@Override
	public void removeItem(Long cartId) {
		// TODO Auto-generated method stub
		cartRepository.deleteById(cartId);
	}

	@Override
	public void clearCart(Long userId) {
		// TODO Auto-generated method stub
		
		 cartRepository.deleteByUserId(userId);
	}

}

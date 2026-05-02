package com.ecommerce.ecommerceproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.ecommerceproject.entity.WishList;
import com.ecommerce.ecommerceproject.repository.ProductRepository;
import com.ecommerce.ecommerceproject.repository.UserRepository;
import com.ecommerce.ecommerceproject.repository.WishListRepository;

@Service
public class WishListServiceImpl implements WishListService{
	
	private final WishListRepository wishListRepository;
	private final UserRepository userRepository;
	private final ProductRepository productRepository;
	
	

	public WishListServiceImpl(WishListRepository wishListRepository, UserRepository userRepository,
			ProductRepository productRepository) {

		this.wishListRepository = wishListRepository;
		this.userRepository = userRepository;
		this.productRepository = productRepository;
	}

	
	@Override
	public WishList add(WishList wishList) {
		// TODO Auto-generated method stub
		Long userId    = wishList.getUser().getId();
		Long productId = wishList.getProduct().getId();
		
		if(!userRepository.existsById(userId)) {
			throw new RuntimeException("User not found");
		}
		
		if(!productRepository.existsById(productId)) {
			throw new RuntimeException("Product not found");
		}
		
		return wishListRepository.save(wishList);
	}

	
	@Override
	public List<WishList> getByUser(Long userId) {
		// TODO Auto-generated method stub
		return wishListRepository.findByUserId(userId);
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		 wishListRepository.deleteById(id);
		
	}

}

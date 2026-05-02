package com.ecommerce.ecommerceproject.service;

import java.util.List;

import com.ecommerce.ecommerceproject.entity.WishList;

public interface WishListService {

	WishList add(WishList wishList);
	
	List<WishList> getByUser(Long userId);
	
	void remove(Long id);
}

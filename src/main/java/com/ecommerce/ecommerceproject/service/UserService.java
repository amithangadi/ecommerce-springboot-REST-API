package com.ecommerce.ecommerceproject.service;

import com.ecommerce.ecommerceproject.entity.User;

public interface UserService {

	User register(User user);
	String login(String email, String password);
}

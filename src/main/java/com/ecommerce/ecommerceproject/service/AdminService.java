package com.ecommerce.ecommerceproject.service;

import com.ecommerce.ecommerceproject.entity.Admin;

public interface AdminService {

	Admin register(Admin admin);
	
	String login(String email, String password);
}

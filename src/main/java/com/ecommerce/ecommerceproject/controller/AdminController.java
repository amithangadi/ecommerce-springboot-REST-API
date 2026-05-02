package com.ecommerce.ecommerceproject.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ecommerceproject.entity.Admin;
import com.ecommerce.ecommerceproject.service.AdminService;

@RestController
@RequestMapping("/api/admins")
public class AdminController {

	private final AdminService service;
	
	public AdminController(AdminService service) {
		this.service = service;
	}
	
	@PostMapping("/register")
	public Admin register(@RequestBody Admin admin) {
		return service.register(admin);
	}
	
	@PostMapping("/login")
	public String login(@RequestBody Map<String, String> data) {
	
		return service.login(
				data.get("email"),
				data.get("password")
		);
	}
}

package com.ecommerce.ecommerceproject.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ecommerce.ecommerceproject.entity.Admin;
import com.ecommerce.ecommerceproject.repository.AdminRepository;
import com.ecommerce.ecommerceproject.repository.UserRepository;

@Service
public class AdminServiceImpl implements AdminService{

	private final AdminRepository adminRepository;
	private final UserRepository userRepository;
	
	public AdminServiceImpl(AdminRepository adminRepository, UserRepository userRepository) {
		this.adminRepository = adminRepository;
		this.userRepository = userRepository;
	}
	
	
	
	@Override
	public Admin register(Admin admin) {
		// TODO Auto-generated method stub
	
		if(adminRepository.existsByEmail(admin.getEmail())) {
			throw new RuntimeException("Admin email already existts");
		}
		
		if(userRepository.existsByEmail(admin.getEmail())) {
			throw new RuntimeException("This email is belongs to user");
		}
		
		return adminRepository.save(admin);
	}

	@Override
	public String login(String email, String password) {
		// if email exists in User table
		if(userRepository.existsByEmail(email)) {
			return "This email belongs to users";
		}
		
		Optional<Admin> optionalAdmin = adminRepository.findByEmail(email);
		
		if(optionalAdmin.isEmpty()) {
			return "Admin not found";
		}
		
		Admin dbAdmin = optionalAdmin.get();
		
		if(!dbAdmin.getPassword().equals(password)) {
			return "Invalid password";
		}
		
		return "Admin login successfully";
	}

}

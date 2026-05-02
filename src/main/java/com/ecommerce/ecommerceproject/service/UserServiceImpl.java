package com.ecommerce.ecommerceproject.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ecommerce.ecommerceproject.entity.User;
import com.ecommerce.ecommerceproject.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	private final UserRepository repository;
	
	public UserServiceImpl(UserRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public User register(User user) {
		// TODO Auto-generated method stub
		if(repository.existsByEmail(user.getEmail())) {
			throw new RuntimeException("Email already exists");
		}
		return repository.save(user);
	}

	@Override
	public String login(String email, String password) {
		// TODO Auto-generated method stub
		Optional<User> optionalUser = repository.findByEmail(email);
		
		if(optionalUser.isEmpty()) {
			return "user not found";
		}
		
		User dbUser = optionalUser.get();
		
		if(!dbUser.getPassword().equals(password)) {
			return "Invalid password";
		}
		
		return "user login successfull";
	}

}

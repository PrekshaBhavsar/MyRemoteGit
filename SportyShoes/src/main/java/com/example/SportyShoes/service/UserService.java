package com.example.SportyShoes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.SportyShoes.entity.User;
import com.example.SportyShoes.repository.UserRepository;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository userrepository;
	
	
	public User findUserByEmail(String email) {
		 return userrepository.findByEmail(email);
		
	}
	public List<User> ListAllUser() {
		return userrepository.findAll();
	}

}

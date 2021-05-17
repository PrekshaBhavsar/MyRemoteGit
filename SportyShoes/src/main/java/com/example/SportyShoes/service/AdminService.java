package com.example.SportyShoes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SportyShoes.entity.Admin;
import com.example.SportyShoes.repository.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepository adminrepository;
	
	public Admin findAdminByName(String name) {
		 return adminrepository.findByName(name);
		
	}

}

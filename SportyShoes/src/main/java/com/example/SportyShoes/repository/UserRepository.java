package com.example.SportyShoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SportyShoes.entity.User;

public interface UserRepository extends JpaRepository<User,Long>{

	User findByEmail(String email);
	

	

}

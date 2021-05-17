package com.example.SportyShoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SportyShoes.entity.Admin;


public interface AdminRepository extends JpaRepository<Admin,Long>{

	Admin findByName(String name);
}

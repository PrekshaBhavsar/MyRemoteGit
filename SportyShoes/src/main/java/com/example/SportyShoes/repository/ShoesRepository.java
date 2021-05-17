package com.example.SportyShoes.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.SportyShoes.entity.Shoes;
import com.example.SportyShoes.entity.User;


public interface ShoesRepository extends JpaRepository<Shoes,Long> {
	


	List<Shoes> findByGender(String gender);
	List<Shoes> findByColor(String color);
	List<Shoes> findByBrand(String brand);
	List<Shoes> findByIspurchased(String ispurchased);
	List<Shoes> findByPurchasedate(String purchasedate);
	
	List<Shoes> findByIspurchasedAndPurchasedate(String ispurchased,String purchasedate);
	List<Shoes> findByGenderAndColorAndBrandAndIspurchasedAndPurchasedate(String gender,String color,String brand,String ispurchased,String purchasedate);
	
	@Transactional
	@Modifying
	@Query("update Shoes s set s.size = :size,s.color = :color,s.brand = :brand,s.gender = :gender,s.purchasedate = :purchasedate where s.id = :id")
	void updateProduct(@Param("id") Long id, @Param("size") String size,@Param("color") String color,@Param("brand") String brand,@Param("gender") String gender,@Param("purchasedate") String PurchaseDate);
	
}

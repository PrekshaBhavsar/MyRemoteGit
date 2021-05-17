package com.example.SportyShoes.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.SportyShoes.entity.Shoes;
import com.example.SportyShoes.repository.ShoesRepository;



@Service
@Transactional
public class ShoesService {
	

	List<Shoes> Allshoes = new ArrayList<Shoes>();
	
	@Autowired
	private ShoesRepository dao;


	public void addShoes(String size, String color, String gender, String brand,String date,String Ispuchased) {
		dao.save(new Shoes(size,color,gender,brand,date,Ispuchased));
		
	}

	public List<Shoes> ListAllShoes() {
		
		return dao.findAll();
	}
	
	public boolean findbyid(Long id) {
		
		Optional<Shoes> find = dao.findById(id);
		
		if(find.isPresent()) {
			System.out.println("Find by id:"+find);
			return true;
		}
		return false;
	}
	
	public boolean deletebyid(Long id) {

		Optional<Shoes> find= dao.findById(id);

		if(find.isPresent()) {
			dao.deleteById(id);
			return true;
		}
		return false;
	}
	
    public Shoes retrieveShoes(Long id) {
    	
    List<Shoes> Allshoesdata = dao.findAll();
        for (Shoes shoes1 : Allshoesdata) {
            if (shoes1.getId()==id) {
                return shoes1;
            }
        }
        return null;
    }
	
    
    public List<Shoes> retrieveByGender(String Gender){

    	Allshoes = dao.findByGender(Gender);
    	return Allshoes;
    }

	public List<Shoes> retrieveByColor(String color) {
    	
    	Allshoes = dao.findByColor(color);
    	return Allshoes;
	}
	public List<Shoes> retrieveByBrand(String brand) {
    	Allshoes = dao.findByBrand(brand);
    	return Allshoes;
	}
	public List<Shoes> retrieveByIspurchased(String ispurchased) {
		Allshoes = dao.findByIspurchased(ispurchased);
    	return Allshoes;
	}
	public List<Shoes> retrieveByDate(String date) {
		Allshoes = dao.findByPurchasedate(date);
    	return Allshoes;
	}
	public List<Shoes> retrieveBypurchasedate(String ispurchased,String date) {
		Allshoes = dao.findByIspurchasedAndPurchasedate(ispurchased,date);
    	return Allshoes;
	}
	public List<Shoes> retrieveByAll(String gender,String color,String brand,String ispurchased,String purchasedate) {
		Allshoes = dao.findByGenderAndColorAndBrandAndIspurchasedAndPurchasedate(gender, color, brand,ispurchased,purchasedate);
    	return Allshoes;
	}


	

}

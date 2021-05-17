package com.example.SportyShoes.entity;

//import java.time.LocalDateTime;
//import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Shoes {
	
	@Id
	@GeneratedValue
	private Long id;
	
	
	private String size;
	private String color;
	private String gender;
	private String brand;
	private String ispurchased;
	private String purchasedate;
	
	
	public Shoes() {
		
	}
	//@CreationTimestamp
	//private LocalDateTime createdDate;



	public Long getId() {
		return id;
	}

	public Shoes(String size, String color, String gender, String brand, String purchasedate, String ispurchased) {
		super();
		this.size = size;
		this.color = color;
		this.gender = gender;
		this.brand = brand;
		this.purchasedate = purchasedate;
		this.ispurchased = ispurchased;
	}
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getPurchasedate() {
		return purchasedate;
	}

	public void setPurchasedate(String purchasedate) {
		this.purchasedate = purchasedate;
	}
	

	public String getIspurchased() {
		return ispurchased;
	}

	public void setIspurchased(String ispurchased) {
		this.ispurchased = ispurchased;
	}

	@Override
	public String toString() {
		return "Shoes [id=" + id + ", size=" + size + ", color=" + color + ", gender=" + gender + ", brand=" + brand
				+ ", purchasedate=" + purchasedate + ", ispurchased=" + ispurchased + "]";
	}

}

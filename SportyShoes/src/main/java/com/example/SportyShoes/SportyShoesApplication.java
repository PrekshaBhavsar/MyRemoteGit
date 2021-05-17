package com.example.SportyShoes;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@ComponentScan("com")
//@EntityScan("com.entity")
//@EnableJpaRepositories("com.dao")

@SpringBootApplication
public class SportyShoesApplication {

	public static void main(String[] args)  {
		SpringApplication.run(SportyShoesApplication.class, args);
	}

}

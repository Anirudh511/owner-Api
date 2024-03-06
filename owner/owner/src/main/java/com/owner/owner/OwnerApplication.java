package com.owner.owner;


import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class OwnerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OwnerApplication.class, args);
	}
	@Bean
	ModelMapper modelMapper(){
		return new ModelMapper();
	}


}

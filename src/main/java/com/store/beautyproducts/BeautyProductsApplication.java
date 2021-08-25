package com.store.beautyproducts;

import com.store.beautyproducts.services.S3Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BeautyProductsApplication implements CommandLineRunner{

	@Autowired
	private S3Service s3Service;
	public static void main(String[] args) {
		SpringApplication.run(BeautyProductsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		s3Service.uploadFile("C:\\Users\\lTHINGl\\Pictures\\transferir.jpg");
	} 

}

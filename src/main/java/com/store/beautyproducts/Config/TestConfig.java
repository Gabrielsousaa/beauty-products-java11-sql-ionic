package com.store.beautyproducts.Config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.store.beautyproducts.services.DBService;
import com.store.beautyproducts.services.EmailService;
import com.store.beautyproducts.services.MockEmailService;

@Configuration
@Profile("test")
public class TestConfig {
    @Autowired
    private DBService dbservice;

    @Bean
    public boolean instantiateDatabase() throws ParseException{
        dbservice.instantiateTestDatabase();
        return true;   
    }

    @Bean
    public EmailService emailService(){
        return new MockEmailService(); 
    }
}

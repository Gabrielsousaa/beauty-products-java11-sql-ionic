package com.store.beautyproducts.services;

import com.store.beautyproducts.domain.tb_Order;

import org.springframework.mail.SimpleMailMessage;

public interface EmailService {
    
    void sendOrderConfirmationEmail(tb_Order obj);

    void sendEmail(SimpleMailMessage msg);
    


}

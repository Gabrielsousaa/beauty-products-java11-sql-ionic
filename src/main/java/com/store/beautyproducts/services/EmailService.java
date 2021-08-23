package com.store.beautyproducts.services;

import javax.mail.internet.MimeMessage;

import com.store.beautyproducts.domain.tb_Order;

import org.springframework.mail.SimpleMailMessage;

public interface EmailService {
    
    void sendOrderConfirmationEmail(tb_Order obj);

    void sendEmail(SimpleMailMessage msg);
    
    void sendOrderConfirmationHtmlEmail(tb_Order obj);

    void sendHtmlEmail(MimeMessage msg);


}

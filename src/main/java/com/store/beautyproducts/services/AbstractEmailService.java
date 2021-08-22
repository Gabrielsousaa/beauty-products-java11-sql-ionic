package com.store.beautyproducts.services;

import com.store.beautyproducts.domain.tb_Order;

import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

public abstract class AbstractEmailService implements EmailService {

    @Value("${default.sender}")
    private String sender;
    
    @Override
    public void sendOrderConfirmationEmail(tb_Order obj){
        SimpleMailMessage sm = prepareSimpleMailMessageFromOrder(obj);
        sendEmail(sm);
    }

    protected SimpleMailMessage prepareSimpleMailMessageFromOrder(tb_Order obj) {
        SimpleMailMessage sm = new SimpleMailMessage();
        sm.setTo(obj.getClient().getEmail());
        sm.setFrom(sender);
        sm.setSubject("Pedido confirmado" + obj.getId());
        sm.setSentDate(new Date(System.currentTimeMillis()));
        sm.setText(obj.toString());
        return sm;
    }
}

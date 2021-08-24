package com.store.beautyproducts.services;

import com.store.beautyproducts.domain.tb_Client;
import com.store.beautyproducts.domain.tb_Order;

import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

public abstract class AbstractEmailService implements EmailService {

    @Value("${default.sender}")
    private String sender;
    @Autowired
    private TemplateEngine templateEngine;
    @Autowired(required = false)
    private JavaMailSender javaMailSender;

    @Override
    public void sendOrderConfirmationEmail(tb_Order obj) {
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

    protected String htmlFromTemplateOrder(tb_Order obj) {

        Context context = new Context();
        context.setVariable("order", obj);
        return templateEngine.process("email/OrderConfirmation", context);

    }

    @Override
    public void sendOrderConfirmationHtmlEmail(tb_Order obj) {
        try {
            MimeMessage mm = prepareMimeMailMessageFromOrder(obj);
            sendHtmlEmail(mm);

        } catch (MessagingException e) {
            sendOrderConfirmationHtmlEmail(obj);
        }

    }

    protected MimeMessage prepareMimeMailMessageFromOrder(tb_Order obj) throws MessagingException {
        MimeMessage mm = javaMailSender.createMimeMessage();
        MimeMessageHelper mmh = new MimeMessageHelper(mm, true);
        mmh.setTo(obj.getClient().getEmail());
        mmh.setFrom(sender);
        mmh.setSubject("Pedido Confirmado! Código" + obj.getId());
        mmh.setSentDate(new Date(System.currentTimeMillis()));
        mmh.setText(htmlFromTemplateOrder(obj), true);
        return mm;

    }

    @Override
    public void sendNewPasswordEmail(tb_Client client, String newPass){
        SimpleMailMessage sm = prepareNewPasswordEmail(client, newPass);
        sendEmail(sm);
    }
    
    protected SimpleMailMessage prepareNewPasswordEmail(tb_Client client, String newPass) {
        SimpleMailMessage sm =  new SimpleMailMessage();
        sm.setTo(client.getEmail());
        sm.setFrom(sender);
       sm.setSubject("Solicitação de nova senha");
        sm.setSentDate(new Date(System.currentTimeMillis()));
        sm.setText("Nova senha: " + newPass);
        return sm;
    }

}

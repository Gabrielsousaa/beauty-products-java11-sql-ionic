package com.store.beautyproducts.services;

import java.util.Random;

import com.store.beautyproducts.domain.tb_Client;
import com.store.beautyproducts.repositories.ClientRepository;
import com.store.beautyproducts.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private BCryptPasswordEncoder pe;

    @Autowired
    private EmailService emailService;


    private Random random = new Random();

    public void sendNewPassword(String email){
        tb_Client client = clientRepository.findByEmail(email);
    
        if(client == null){
            throw new ObjectNotFoundException("Email não encontrado");
        }
        String newPass = newPassword();
        client.setPassword(pe.encode(newPass));
        
        clientRepository.save(client);
        emailService.sendNewPasswordEmail(client, newPass);
    }

    private String newPassword() {
        char[] vet = new char[10];
        
        for(int i = 0; i < vet.length; i++){
            vet[i] = randomChar();
        }

        return new String(vet);
    }

    private char randomChar() {
        int opt = random.nextInt(3);
        if(opt == 0){
            return (char) (random.nextInt(10) + 48);
        }
        else if(opt == 1){
            return (char) (random.nextInt(26) + 65);
        }else{
            return (char) (random.nextInt(26) + 97);
        }
    }

}

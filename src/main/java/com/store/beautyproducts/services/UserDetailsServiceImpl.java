package com.store.beautyproducts.services;

import com.store.beautyproducts.Security.UserSS;
import com.store.beautyproducts.domain.tb_Client;
import com.store.beautyproducts.repositories.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ClientRepository repo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    tb_Client cli = repo.findByEmail(email);
    if (cli == null) {
        throw new UsernameNotFoundException(email);
    }
        return new UserSS(cli.getId(),cli.getEmail(),cli.getPassword(), cli.getProfiles());
    }
    
}
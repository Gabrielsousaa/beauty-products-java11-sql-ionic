package com.store.beautyproducts.services;

import java.util.List;

import com.store.beautyproducts.domain.tb_Estate;
import com.store.beautyproducts.repositories.EstateRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstateService {
    @Autowired
    private EstateRepository repo;

    public List<tb_Estate> findAll() {
        return repo.findAllByOrderByName();
    }
}

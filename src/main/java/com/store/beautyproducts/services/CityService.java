package com.store.beautyproducts.services;

import java.util.List;

import com.store.beautyproducts.domain.tb_City;
import com.store.beautyproducts.repositories.CityRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {
    @Autowired
    private CityRepository repo;

    public List<tb_City> findByEstate(Integer estateId) {
        return repo.findCities(estateId);
    }
}

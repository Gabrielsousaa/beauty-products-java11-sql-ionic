package com.store.beautyproducts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.beautyproducts.domain.tb_City;

@Repository
public interface CityRepository extends JpaRepository<tb_City, Integer> {
    
}

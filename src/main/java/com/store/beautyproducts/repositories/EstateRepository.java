package com.store.beautyproducts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.beautyproducts.domain.tb_Estate;

@Repository
public interface EstateRepository extends JpaRepository<tb_Estate, Integer> {
    
}

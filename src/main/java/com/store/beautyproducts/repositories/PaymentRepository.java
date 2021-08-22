package com.store.beautyproducts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.beautyproducts.domain.tb_Payment;

@Repository
public interface PaymentRepository extends JpaRepository<tb_Payment, Integer> {
    
}

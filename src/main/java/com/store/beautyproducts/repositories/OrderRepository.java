package com.store.beautyproducts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.beautyproducts.domain.tb_Order;

@Repository
public interface OrderRepository extends JpaRepository<tb_Order, Integer> {
    
}

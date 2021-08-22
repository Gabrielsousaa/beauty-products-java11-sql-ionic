package com.store.beautyproducts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.beautyproducts.domain.tb_Address;

@Repository
public interface AddressRepository extends JpaRepository<tb_Address, Integer> {
    
}

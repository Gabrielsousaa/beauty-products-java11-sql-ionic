package com.store.beautyproducts.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.store.beautyproducts.domain.tb_Client;

@Repository
public interface ClientRepository extends JpaRepository<tb_Client, Integer> {
    
    @Transactional(readOnly = true)
    tb_Client findByEmail(String email);
}

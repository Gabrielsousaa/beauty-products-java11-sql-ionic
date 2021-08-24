package com.store.beautyproducts.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.store.beautyproducts.domain.tb_Client;
import com.store.beautyproducts.domain.tb_Order;

@Repository
public interface OrderRepository extends JpaRepository<tb_Order, Integer> {

    @Transactional(readOnly = true)
    Page<tb_Order> findByClient(tb_Client client, Pageable pageRequest);


}

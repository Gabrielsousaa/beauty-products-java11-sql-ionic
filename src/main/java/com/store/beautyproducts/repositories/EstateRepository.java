package com.store.beautyproducts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.store.beautyproducts.domain.tb_Estate;

@Repository
public interface EstateRepository extends JpaRepository<tb_Estate, Integer> {
    @Transactional(readOnly = true)
    public List<tb_Estate> findAllByOrderByName();
}

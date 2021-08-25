package com.store.beautyproducts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



import com.store.beautyproducts.domain.tb_City;

@Repository
public interface CityRepository extends JpaRepository<tb_City, Integer> {
    
    @Transactional(readOnly = true)
    @Query("SELECT obj FROM tb_City obj WHERE obj.estate.id = :estateId ORDER BY obj.name")
    public List<tb_City> findCities(@Param("estateId") Integer estate_id);
}

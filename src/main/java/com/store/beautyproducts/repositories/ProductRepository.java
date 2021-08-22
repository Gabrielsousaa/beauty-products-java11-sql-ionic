package com.store.beautyproducts.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.store.beautyproducts.domain.tb_Category;
import com.store.beautyproducts.domain.tb_Product;

@Repository
public interface ProductRepository extends JpaRepository<tb_Product, Integer> {
    // tanto pode ser pela Query usando @param("name") @Param("categories") ou pelo nome da Page
    //@Query("SELECT DISTINCT obj from tb_Product obj INNER JOIN obj.categories cat WHERE obj.name LIKE %:name% AND cat in :categories" )
    @Transactional(readOnly = true)
    Page<tb_Product> findDistinctByNameContainingAndCategoriesIn(String name, List<tb_Category> categories, Pageable pageRequest);
}

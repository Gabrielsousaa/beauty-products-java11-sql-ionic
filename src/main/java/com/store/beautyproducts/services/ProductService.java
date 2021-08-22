package com.store.beautyproducts.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.store.beautyproducts.domain.tb_Category;
import com.store.beautyproducts.domain.tb_Product;
import com.store.beautyproducts.repositories.CategoryRepository;
import com.store.beautyproducts.repositories.ProductRepository;
import com.store.beautyproducts.services.exceptions.ObjectNotFoundException;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;
    @Autowired
    private CategoryRepository categoryRepository;

    public tb_Product find(Integer id) {
        Optional<tb_Product> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Object not found ID: " + id + ", TypeOf: " + tb_Product.class.getName()));
    }
    /*
    public List<tb_Product> findAll() {
        return repo.findAll();
    }
*/
    public Page<tb_Product> search(String name, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy,
            String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
        List<tb_Category> categories = categoryRepository.findAllById(ids);
        return repo.findDistinctByNameContainingAndCategoriesIn(name, categories, pageRequest);
    }
}

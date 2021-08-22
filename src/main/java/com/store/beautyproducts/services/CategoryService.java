package com.store.beautyproducts.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.store.beautyproducts.domain.tb_Category;
import com.store.beautyproducts.dto.CategoryDTO;
import com.store.beautyproducts.repositories.CategoryRepository;
import com.store.beautyproducts.services.exceptions.DataIntegrityException;
import com.store.beautyproducts.services.exceptions.ObjectNotFoundException;

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository repo;

    public tb_Category find(Integer id){
        Optional<tb_Category> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
        "Object not found ID: " + id + ", TypeOf: " + tb_Category.class.getName())); 
    }

    public tb_Category insert(tb_Category obj){
        obj.setId(null);
        return repo.save(obj);
    }

    public tb_Category update(tb_Category obj){
        tb_Category newObj = find(obj.getId());
        updateData(newObj,obj);
        return repo.save(newObj);
    }

    public void delete(Integer id){
        find(id);
        try {
            repo.deleteById(id);
        } catch (DataIntegrityViolationException e) {
                throw new DataIntegrityException("Não é possivel excluir uma categoria que possui produtos");
        }   
    }

    public List<tb_Category> findAll(){
        return repo.findAll();
    }

    public Page<tb_Category> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage , Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);
    }

    public tb_Category fromDTO(CategoryDTO objDTO){
        return new tb_Category(objDTO.getId(), objDTO.getName());
    }

        private void updateData(tb_Category newObj, tb_Category obj){
        newObj.setName(obj.getName());
    }
}

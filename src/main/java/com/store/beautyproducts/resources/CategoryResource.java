package com.store.beautyproducts.resources;


import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.store.beautyproducts.domain.tb_Category;
import com.store.beautyproducts.dto.CategoryDTO;
import com.store.beautyproducts.services.CategoryService;


@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
    @Autowired
    private CategoryService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<tb_Category> find(@PathVariable Integer id){
        tb_Category obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CategoryDTO objDTO){
        tb_Category obj = service.fromDTO(objDTO);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
        .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody CategoryDTO objDTO, @PathVariable Integer id ){// o @Valid deve ser seguido pelo @RequestBody para verificar o Corpo que está sendo enviado
        tb_Category obj = service.fromDTO(objDTO);
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }
    
    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping()
    public ResponseEntity<List<CategoryDTO>> findAll(){
        List<tb_Category> list = service.findAll();
        List<CategoryDTO> listDTO = list.stream().map(obj -> new CategoryDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }
    @GetMapping(value = "/page")
    public ResponseEntity<Page<CategoryDTO>> findPage(
        @RequestParam(value = "page", defaultValue = "0")Integer page, 
        @RequestParam(value = "linerPerPage", defaultValue = "24")Integer linesPerPage, 
        @RequestParam(value = "orderBy", defaultValue = "name")String orderBy, 
        @RequestParam(value = "direction", defaultValue = "ASC")String direction){
        Page<tb_Category> list = service.findPage(page, linesPerPage, orderBy, direction);
        Page<CategoryDTO> listDTO = list.map(obj -> new CategoryDTO(obj));
        return ResponseEntity.ok().body(listDTO);
    }

    
}

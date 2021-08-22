package com.store.beautyproducts.resources;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.store.beautyproducts.domain.tb_Product;
import com.store.beautyproducts.dto.ProductDTO;
import com.store.beautyproducts.resources.utils.URL;
import com.store.beautyproducts.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
    @Autowired
    private ProductService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<tb_Product> find(@PathVariable Integer id) {
        tb_Product obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }
    
   /* @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll() {
        List<tb_Product> list = service.findAll();
        List<ProductDTO> listDTO = list.stream().map(obj -> new ProductDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }
*/
    @GetMapping
    public ResponseEntity<Page<ProductDTO>> findPage(@RequestParam(value = "name", defaultValue = "") String name,
            @RequestParam(value = "categories", defaultValue = "") String categories,
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linerPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction) {
        String nameDecoded = URL.decodeParam(name);
        List<Integer> ids = URL.decodeIntList(categories);
        Page<tb_Product> list = service.search(nameDecoded, ids, page, linesPerPage, orderBy, direction);
        Page<ProductDTO> listDTO = list.map(obj -> new ProductDTO(obj));
        return ResponseEntity.ok().body(listDTO);
    }

}

package com.store.beautyproducts.resources;


import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.store.beautyproducts.domain.tb_Order;
import com.store.beautyproducts.services.OrderService;


@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
    @Autowired
    private OrderService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<tb_Order> find(@PathVariable Integer id){
        tb_Order obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }
    
    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody tb_Order obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    
    @GetMapping()
    public ResponseEntity<Page<tb_Order>> findPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linerPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "instant") String orderBy,
            @RequestParam(value = "direction", defaultValue = "DESC") String direction) {
        Page<tb_Order> list = service.findPage(page, linesPerPage, orderBy, direction);
        return ResponseEntity.ok().body(list);
    }
}

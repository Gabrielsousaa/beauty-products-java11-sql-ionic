package com.store.beautyproducts.dto;

import java.io.Serializable;

import com.store.beautyproducts.domain.tb_Product;

public class ProductDTO implements Serializable
{
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;
    private Float price;

    public ProductDTO() {
    }

    public ProductDTO(tb_Product obj) {
        id = obj.getId();
        name = obj.getName();
        price = obj.getPrice();
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Float getPrice() {
        return price;
    }
    public void setPrice(Float price) {
        this.price = price;
    }
    
}

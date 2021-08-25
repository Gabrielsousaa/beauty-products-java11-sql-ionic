package com.store.beautyproducts.dto;

import java.io.Serializable;

import com.store.beautyproducts.domain.tb_City;

public class CityDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;

	public CityDTO() {
	}

	public CityDTO(tb_City obj) {
		id = obj.getId();
		name = obj.getName();
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
}


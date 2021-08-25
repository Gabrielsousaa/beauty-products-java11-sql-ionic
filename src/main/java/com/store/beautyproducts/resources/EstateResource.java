package com.store.beautyproducts.resources;

import java.util.List;
import java.util.stream.Collectors;

import com.store.beautyproducts.domain.tb_City;
import com.store.beautyproducts.domain.tb_Estate;
import com.store.beautyproducts.dto.CityDTO;
import com.store.beautyproducts.dto.EstateDTO;
import com.store.beautyproducts.services.CityService;
import com.store.beautyproducts.services.EstateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/estates")
public class EstateResource {
    
    @Autowired
    private EstateService service;

    @Autowired
    private CityService cityService;

    @GetMapping
    public ResponseEntity<List<EstateDTO>> findAll() {
        List<tb_Estate>list = service.findAll();
        List<EstateDTO> listDto = list.stream().map(obj -> new EstateDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{estateId}/cities")
    public ResponseEntity<List<CityDTO>> findCity(@PathVariable Integer estateId) {
        List<tb_City> list = cityService.findByEstate(estateId);
        List<CityDTO> listDto = list.stream().map(obj -> new CityDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }
}

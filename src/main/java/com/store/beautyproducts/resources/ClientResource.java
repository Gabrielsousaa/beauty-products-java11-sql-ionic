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

import com.store.beautyproducts.domain.tb_Client;
import com.store.beautyproducts.dto.ClientDTO;
import com.store.beautyproducts.dto.ClientNewDTO;
import com.store.beautyproducts.services.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {
    @Autowired
    private ClientService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<tb_Client> find(@PathVariable Integer id){
        tb_Client obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody ClientNewDTO objDTO){
        tb_Client obj = service.fromDTO(objDTO);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
        .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody ClientDTO objDTO, @PathVariable Integer id ){// o @Valid deve ser seguido pelo @RequestBody para verificar o Corpo que está sendo enviado
        tb_Client obj = service.fromDTO(objDTO);
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
    
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping()
    public ResponseEntity<List<ClientDTO>> findAll(){
        List<tb_Client> list = service.findAll();
        List<ClientDTO> listDTO = list.stream().map(obj -> new ClientDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }
    
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping(value = "/page")
    public ResponseEntity<Page<ClientDTO>> findPage(
        @RequestParam(value = "page", defaultValue = "0")Integer page, 
        @RequestParam(value = "linerPerPage", defaultValue = "24")Integer linesPerPage, 
        @RequestParam(value = "orderBy", defaultValue = "name")String orderBy, 
        @RequestParam(value = "direction", defaultValue = "ASC")String direction){
        Page<tb_Client> list = service.findPage(page, linesPerPage, orderBy, direction);
        Page<ClientDTO> listDTO = list.map(obj -> new ClientDTO(obj));
        return ResponseEntity.ok().body(listDTO);
    }

}
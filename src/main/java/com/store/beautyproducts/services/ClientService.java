package com.store.beautyproducts.services;

import java.net.URI;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import com.store.beautyproducts.services.exceptions.AuthorizationException;
import com.store.beautyproducts.services.exceptions.DataIntegrityException;
import com.store.beautyproducts.Security.UserSS;
import com.store.beautyproducts.domain.tb_Address;
import com.store.beautyproducts.domain.tb_City;
import com.store.beautyproducts.domain.tb_Client;
import com.store.beautyproducts.domain.enums.ClientType;
import com.store.beautyproducts.domain.enums.Profile;
import com.store.beautyproducts.dto.ClientDTO;
import com.store.beautyproducts.dto.ClientNewDTO;
import com.store.beautyproducts.repositories.AddressRepository;
import com.store.beautyproducts.repositories.ClientRepository;
import com.store.beautyproducts.services.exceptions.ObjectNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import java.awt.image.BufferedImage;
@Service
public class ClientService {
    @Autowired
    private BCryptPasswordEncoder pe;

    @Autowired
    private ClientRepository repo;
    
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private S3Service s3Service;

    @Autowired
    private ImageService imageService;

    @Value("${img.prefix.client.profile}")
    private String prefix;

    public tb_Client find(Integer id){
        UserSS user = UserService.authenticate();

        if(user == null || user.hasRole(Profile.ADMIN) && !id.equals(user.getUserId())){
            throw new AuthorizationException("Acesso negado");
        }
    
        Optional<tb_Client> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
        "Object not found ID: " + id + ", TypeOf: " + tb_Client.class.getName())); 
    }
    @Transactional
    public tb_Client insert(tb_Client obj){
        obj.setId(null);
        obj = repo.save(obj);
        addressRepository.saveAll(obj.getAddresses());
        return obj;
    }

    public tb_Client update(tb_Client obj){
        tb_Client newObj = find(obj.getId());
        updateData(newObj,obj);
        return repo.save(newObj);
    }

    public void delete(Integer id){
        find(id);
        try {
            repo.deleteById(id);
        } catch (DataIntegrityViolationException e) {
                throw new DataIntegrityException("Não é possivel excluir porque há pedidos relacionadas");
        }   
    }

    public List<tb_Client> findAll(){
        return repo.findAll();
    }

    public Page<tb_Client> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage , Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);
    }

    public tb_Client fromDTO(ClientDTO objDTO){
        return new tb_Client(objDTO.getId(), objDTO.getName(), objDTO.getEmail(),null, null ,null);
    }
    public tb_Client fromDTO(ClientNewDTO objDTO){

        tb_Client cli = new tb_Client(null, objDTO.getName(), objDTO.getEmail(),pe.encode(objDTO.getPassword()), 
        objDTO.getCPFouCNPJ(), ClientType.toEnum(objDTO.getClientType()));

        tb_City cid = new tb_City(objDTO.getCityId(), null, null);

        tb_Address addr = new tb_Address(null, objDTO.getPublicPlace(), objDTO.getNumber(), 
        objDTO.getFullAddress(), objDTO.getDistrict(), objDTO.getZipCode(), cli, cid);

        cli.getAddresses().add(addr);
        cli.getPhones().add(objDTO.getPhoneNumber1());

        if (objDTO.getPhoneNumber2() != null) {
            cli.getPhones().add(objDTO.getPhoneNumber2());
        }
        if (objDTO.getPhoneNumber3() != null) {
            cli.getPhones().add(objDTO.getPhoneNumber3());
        }

        return cli;

        
    }

    private void updateData(tb_Client newObj, tb_Client obj){
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

    public URI uploadProfilePicture(MultipartFile multipartFile){

        UserSS user = UserService.authenticate();
        
        if (user == null) {
            throw new AuthorizationException("Acesso negado");
        }

        BufferedImage jpgImage = imageService.getJpgImageFromFile(multipartFile);
        String fileName = prefix + user.getUserId() + ".jpg";
        return s3Service.uploadFile(imageService.getInputStream(jpgImage, "jpg"),fileName, "image");
    }

}
package com.store.beautyproducts.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;



import org.hibernate.validator.constraints.Length;


import com.store.beautyproducts.services.validation.ClientInsert;

@ClientInsert
public class ClientNewDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min=5,max=120, message = "O tamanho deve ser entre 5 e 120 caracteres")
    private String name;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min=5,max=120, message = "O tamanho deve ser entre 5 e 120 caracteres")
    private String email;

    @NotEmpty(message = "Preenchimento obrigatório")

    private String CPFouCNPJ;

    private Integer clientType;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min=5,max=120, message = "O tamanho deve ser entre 5 e 120 caracteres")
    private String publicPlace;
    
    @NotEmpty(message = "Preenchimento obrigatório")
    private String number;
    
    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min=5,max=120, message = "O tamanho deve ser entre 5 e 120 caracteres")
    private String fullAddress;
    
    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min=5,max=120, message = "O tamanho deve ser entre 5 e 120 caracteres")
    private String district;
    
    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min=5,max=120, message = "O tamanho deve ser entre 5 e 120 caracteres")
    private String zipCode;

    @NotEmpty(message = "Preenchimento obrigatório")
    private String password;

    private String phoneNumber1;
    private String phoneNumber2;
    private String phoneNumber3;

    private Integer cityId;

    public ClientNewDTO(){

    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCPFouCNPJ() {
        return CPFouCNPJ;
    }

    public void setCPFouCNPJ(String CPFouCNPJ) {
        this.CPFouCNPJ = CPFouCNPJ;
    }

    public Integer getClientType() {
        return clientType;
    }

    public void setClientType(Integer clientType) {
        this.clientType = clientType;
    }

    public String getPublicPlace() {
        return publicPlace;
    }

    public void setPublicPlace(String publicPlace) {
        this.publicPlace = publicPlace;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhoneNumber1() {
        return phoneNumber1;
    }

    public void setPhoneNumber1(String phoneNumber1) {
        this.phoneNumber1 = phoneNumber1;
    }

    public String getPhoneNumber2() {
        return phoneNumber2;
    }

    public void setPhoneNumber2(String phoneNumber2) {
        this.phoneNumber2 = phoneNumber2;
    }

    public String getPhoneNumber3() {
        return phoneNumber3;
    }

    public void setPhoneNumber3(String phoneNumber3) {
        this.phoneNumber3 = phoneNumber3;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }
    

}

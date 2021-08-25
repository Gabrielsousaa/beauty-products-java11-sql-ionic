package com.store.beautyproducts.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import com.fasterxml.jackson.annotation.JsonIgnore;


import com.store.beautyproducts.domain.enums.ClientType;
import com.store.beautyproducts.domain.enums.Profile;

@Entity
public class tb_Client implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @Column(unique = true)
    private String email;
    private String CPFouCNPJ;
    private Integer clientType;

    @JsonIgnore
    private String password;


    @OneToMany(mappedBy = "client",  cascade = CascadeType.ALL)
    private List<tb_Address> addresses = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "tb_phone_number")
    private Set<String> phones = new HashSet<>();
    
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "PROFILES")
    private Set<Integer> profiles = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private List<tb_Order> orders = new ArrayList<>();

    public tb_Client() {
    addProfile(Profile.CLIENT);
    }


    public tb_Client(Integer id, String name, String email, String password, String CPFouCNPJ, ClientType clientType) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
        this.CPFouCNPJ = CPFouCNPJ;
        this.clientType = (clientType == null) ? null : clientType.getCod();
        addProfile(Profile.CLIENT);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getCPFouCNPJ() {
        return CPFouCNPJ;
    }
    
    public void setCPFouCNPJ(String CPFouCNPJ) {
        this.CPFouCNPJ = CPFouCNPJ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    

    public void setEmail(String email) {
        this.email = email;
    }
    public Set<Profile> getProfiles(){
        return profiles.stream().map(x -> Profile.toEnum(x)).collect(Collectors.toSet());
    }
    public void addProfile(Profile profile) {
        profiles.add(profile.getCod());
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ClientType getClientType() {
        return ClientType.toEnum(clientType);
    }

    public void setClientType(ClientType clientType) {
        this.clientType = clientType.getCod();
    }

    public Set<String> getPhones() {
        return phones;
    }

    public void setPhones(Set<String> phones) {
        this.phones = phones;
    }
    
    public List<tb_Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<tb_Address> addresses) {
        this.addresses = addresses;
    }
    
    public List<tb_Order> getOrders() {
        return orders;
    }

    public void setOrders(List<tb_Order> orders) {
        this.orders = orders;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        tb_Client other = (tb_Client) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    

}

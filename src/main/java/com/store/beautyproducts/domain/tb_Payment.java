package com.store.beautyproducts.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.store.beautyproducts.domain.enums.StatusPayment;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@type")
public abstract class tb_Payment implements Serializable{ //o abstract garante que não podera instanciar objetos do tipo tb_Payment
    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;
    private Integer status;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "order_id")
    @MapsId
    private tb_Order order;

    public tb_Payment() {
    }
    public tb_Payment(Integer id, StatusPayment status, tb_Order order) {
        this.id = id;
        this.status = (status == null) ? null : status.getCod();
        this.order = order;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public StatusPayment getStatus() {
        return StatusPayment.toEnum(status);
    }
    public void setStatus(StatusPayment status) {
        this.status = status.getCod();
    }
    public tb_Order getOrder() {
        return order;
    }
    public void setOrder(tb_Order order) {
        this.order = order;
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
        tb_Payment other = (tb_Payment) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}

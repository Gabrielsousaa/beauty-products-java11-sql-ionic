package com.store.beautyproducts.domain;


import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonTypeName;

import com.store.beautyproducts.domain.enums.StatusPayment;



@Entity
@JsonTypeName("PaymentWithBankCard")
public class tb_PaymentWithBankCard extends tb_Payment {
    private static final long serialVersionUID = 1L;

    private Integer numberOfInstallments;

    public tb_PaymentWithBankCard(){

    }

    public tb_PaymentWithBankCard(Integer id, StatusPayment status, tb_Order order, Integer numberOfInstallments) {
        super(id, status, order);
        this.numberOfInstallments = numberOfInstallments;
    }

    public Integer getNumberOfInstallments() {
        return numberOfInstallments;
    }

    public void setNumberOfInstallments(Integer numberOfInstallments) {
        this.numberOfInstallments = numberOfInstallments;
    }

}

package com.store.beautyproducts.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeName;

import com.store.beautyproducts.domain.enums.StatusPayment;

@Entity
@JsonTypeName("PaymentWithBankSlip")
public class tb_PaymentWithBankSlip extends tb_Payment {

    private static final long serialVersionUID = 1L;
    

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dueDate;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date payDay;
   
    public tb_PaymentWithBankSlip(){

    }

    public tb_PaymentWithBankSlip(Integer id, StatusPayment status, tb_Order order, Date dueDate, Date payDay) {
        super(id, status, order);
        this.dueDate = dueDate;
        this.payDay = payDay;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getPayDay() {
        return payDay;
    }

    public void setPayDay(Date payDay) {
        this.payDay = payDay;
    }

    

    
    
}

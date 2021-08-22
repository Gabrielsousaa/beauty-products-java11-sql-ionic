package com.store.beautyproducts.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.store.beautyproducts.domain.tb_PaymentWithBankSlip;

@Service
public class BankSlipService{
    public void fillPaymentWithBankSlip(tb_PaymentWithBankSlip pagto , Date instantOfOrder){
        Calendar cal = Calendar.getInstance();
        cal.setTime(instantOfOrder);
        cal.add(Calendar.DAY_OF_MONTH, 7);
        pagto.setDueDate(cal.getTime());

    }

}
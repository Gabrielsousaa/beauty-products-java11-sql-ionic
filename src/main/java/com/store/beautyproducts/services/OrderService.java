package com.store.beautyproducts.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.beautyproducts.domain.tb_ItemOrder;
import com.store.beautyproducts.domain.tb_Order;
import com.store.beautyproducts.domain.tb_PaymentWithBankSlip;
import com.store.beautyproducts.domain.enums.StatusPayment;
import com.store.beautyproducts.repositories.ItemOrderRepository;
import com.store.beautyproducts.repositories.OrderRepository;
import com.store.beautyproducts.repositories.PaymentRepository;

import com.store.beautyproducts.services.exceptions.ObjectNotFoundException;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repo;

    @Autowired
    private BankSlipService backslipService;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private ItemOrderRepository itemOrderRepository;

    public tb_Order find(Integer id) {
        Optional<tb_Order> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Object not found ID: " + id + ", TypeOf: " + tb_Order.class.getName()));
    }

    public tb_Order insert(tb_Order obj) {
        obj.setId(null);
        obj.setInstant(new Date());
        obj.getPayment().setStatus(StatusPayment.PENDING);
        obj.getPayment().setOrder(obj);
        if (obj.getPayment() instanceof tb_PaymentWithBankSlip) {
            tb_PaymentWithBankSlip pagto = (tb_PaymentWithBankSlip) obj.getPayment();
            backslipService.fillPaymentWithBankSlip(pagto, obj.getInstant());
        }
        obj = repo.save(obj);
        paymentRepository.save(obj.getPayment());
        for (tb_ItemOrder ip : obj.getItens()) {
            ip.setDiscount(0.0);
            ip.setProduct(productService.find(ip.getProduct().getId()));
            ip.setPrice(productService.find(ip.getProduct().getId()).getPrice());
            ip.setOrder(obj);

        }
        itemOrderRepository.saveAll(obj.getItens());
        return obj;
    }
}

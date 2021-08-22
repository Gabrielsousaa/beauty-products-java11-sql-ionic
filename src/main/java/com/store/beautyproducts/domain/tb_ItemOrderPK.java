package com.store.beautyproducts.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable// essa anotação diz que é um subtipo
public class tb_ItemOrderPK implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private tb_Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private tb_Product product;
    
    public tb_Order getOrder() {
        return order;
    }
    public void setOrder(tb_Order order) {
        this.order = order;
    }
    public tb_Product getProduct() {
        return product;
    }
    public void setProduct(tb_Product product) {
        this.product = product;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((order == null) ? 0 : order.hashCode());
        result = prime * result + ((product == null) ? 0 : product.hashCode());
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
        tb_ItemOrderPK other = (tb_ItemOrderPK) obj;
        if (order == null) {
            if (other.order != null)
                return false;
        } else if (!order.equals(other.order))
            return false;
        if (product == null) {
            if (other.product != null)
                return false;
        } else if (!product.equals(other.product))
            return false;
        return true;
    }

    

}

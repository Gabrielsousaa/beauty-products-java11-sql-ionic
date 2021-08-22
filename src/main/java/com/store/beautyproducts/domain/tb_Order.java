package com.store.beautyproducts.domain;

import java.io.Serializable;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;



@Entity
public class tb_Order implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date instant;


    @OneToOne(cascade = CascadeType.ALL, mappedBy = "order")
    private tb_Payment payment;

 
    @ManyToOne
    @JoinColumn(name="client_id")
    private tb_Client client;
    
    @ManyToOne
    @JoinColumn(name = "address_delivery_id")
    private tb_Address addressDelivery;

    @OneToMany(mappedBy = "id.order")
    private Set<tb_ItemOrder> itens = new HashSet<>();

    public tb_Order() {
    }


    public tb_Order(Integer id, Date instant, tb_Client client, tb_Address addressDelivery) {
        this.id = id;
        this.instant = instant;
        this.client = client;
        this.addressDelivery = addressDelivery;
    }

    public double getValorTotal(){
        double sum = 0.0;
        for(tb_ItemOrder ip : itens){
            sum = sum + ip.getSubtotal();
        }

        return sum;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Date getInstant() {
        return instant;
    }
    public void setInstant(Date instant) {
        this.instant = instant;
    }
    public tb_Payment getPayment() {
        return payment;
    }
    public void setPayment(tb_Payment payment) {
        this.payment = payment;
    }
    public tb_Client getClient() {
        return client;
    }
    public void setClient(tb_Client client) {
        this.client = client;
    }
    public tb_Address getAddressDelivery() {
        return addressDelivery;
    }
    public void setAddressDelivery(tb_Address addressDelivery) {
        this.addressDelivery = addressDelivery;
        
    }
    
    public Set<tb_ItemOrder> getItens() {
        return itens;
    }

    public void setItens(Set<tb_ItemOrder> itens) {
        this.itens = itens;
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
        tb_Order other = (tb_Order) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }


    @Override
    public String toString() {
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        StringBuilder builder = new StringBuilder();
        builder.append("\n");
        builder.append("Order number: ");
        builder.append(getId());
        builder.append(", Instant: ");
        builder.append(sdf.format(getInstant()));
        builder.append(", Client: ");
        builder.append(getClient().getName());
        builder.append(", Order status: ");
        builder.append(getPayment().getStatus().getDescricao());
        builder.append("\n Detalhes \n");

        for (tb_ItemOrder ip: getItens()){
            builder.append(ip.toString());
        }

        builder.append("Total: ");
        builder.append(nf.format(getValorTotal()));

        return builder.toString();
    }
    
    
    
}

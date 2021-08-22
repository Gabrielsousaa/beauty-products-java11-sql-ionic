package com.store.beautyproducts.domain.enums;



public enum StatusPayment {
    
    
    PENDING(1,"PENDING"),
    PAYOFF(2, "PayOff"),
    CANCELLED(3, "Cancelled"), 
    PAIDORDER(4, "PaidOrder");


    private int cod;
    private String descricao;

    private StatusPayment(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }


    public String getDescricao() {
        return descricao;
    }

    public static StatusPayment toEnum(Integer cod){
        if (cod == null) {
            return null;

        }
        for (StatusPayment x : StatusPayment.values()) {
            if(cod.equals(x.getCod())){
                return x;
            }
        }

        throw new IllegalArgumentException("Invalid ID: " + cod);

    }
}

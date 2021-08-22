package com.store.beautyproducts.services.exceptions;

public class DataIntegrityException extends RuntimeException {
    static final long serialVersionUID = 1L;
    
    public DataIntegrityException(String msg){
        super(msg);
    }

    public DataIntegrityException(String msg,Throwable cause){
        super(msg,cause);
    }
}
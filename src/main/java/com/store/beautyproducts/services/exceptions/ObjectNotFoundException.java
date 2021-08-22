package com.store.beautyproducts.services.exceptions;

public class ObjectNotFoundException extends RuntimeException {
    static final long serialVersionUID = 1L;
    
    public ObjectNotFoundException(String msg){
        super(msg);
    }

    public ObjectNotFoundException(String msg,Throwable cause){
        super(msg,cause);
    }
}
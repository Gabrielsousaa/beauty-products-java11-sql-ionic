package com.store.beautyproducts.services.exceptions;

public class AuthorizationException extends RuntimeException {

    static final long serialVersionUID = 1L;
    
    public AuthorizationException(String msg){
        super(msg);
    }

    public AuthorizationException(String msg,Throwable cause){
        super(msg,cause);
    }
    
}
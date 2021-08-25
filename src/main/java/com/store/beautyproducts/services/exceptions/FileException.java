package com.store.beautyproducts.services.exceptions;

public class FileException extends RuntimeException {
    static final long serialVersionUID = 1L;

    public FileException(String msg){
        super(msg);
    }

    public FileException(String msg,Throwable cause){
        super(msg,cause);
    }
}

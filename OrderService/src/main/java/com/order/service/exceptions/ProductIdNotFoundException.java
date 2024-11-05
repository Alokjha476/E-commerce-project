package com.order.service.exceptions;

public class ProductIdNotFoundException extends RuntimeException{
    public ProductIdNotFoundException(String msg){
        super(msg);

    }
}

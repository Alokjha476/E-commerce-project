package com.order.service.exceptions;

public class OrderNotFoundException extends  RuntimeException{
    public  OrderNotFoundException(String message){
        super(message);

    }
}

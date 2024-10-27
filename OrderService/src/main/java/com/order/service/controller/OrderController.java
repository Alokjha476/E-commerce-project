package com.order.service.controller;

import com.order.service.dto.OrderDto;
import com.order.service.entity.Orders;
import com.order.service.service.OrderService;
import org.hibernate.boot.jaxb.hbm.spi.JaxbHbmOuterJoinEnum;
import org.hibernate.query.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/add")
    public ResponseEntity<Object> placeOrder(@RequestBody OrderDto orderDto) {
        Orders order = orderService.addOrder(orderDto);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }
    @GetMapping("/getOrderById/{id}")
    public ResponseEntity<Object> getOrderById(@PathVariable Long orderId){
        Orders orders = orderService.getOrderById(orderId);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }


}

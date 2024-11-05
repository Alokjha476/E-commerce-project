package com.order.service.controller;

import com.order.service.dto.OrderDto;
import com.order.service.entity.Orders;
import com.order.service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/getAll")
    public ResponseEntity<Object> getAllOrders(){
        List<Orders> ordersList = orderService.getAllOrder();
        return new ResponseEntity<>(ordersList, HttpStatus.OK);
    }

    @GetMapping("/getOrderById/{orderId}")
    public ResponseEntity<Object> getOrderById(@PathVariable Long orderId) {
        Orders orders = orderService.getOrderById(orderId);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @PutMapping("/update/{orderId}")
    public ResponseEntity<Object> editOrder(@PathVariable Long orderId, @RequestBody OrderDto orderDto) {
        Orders orders = orderService.updateOrder(orderId, orderDto);
        return new ResponseEntity<>("Order updated successfully: " + orderId, HttpStatus.OK);

    }

    @DeleteMapping("/cancel/{orderId}")
    public ResponseEntity<Object> cancelOrder(@PathVariable Long orderId) {
        orderService.cancelOrder(orderId);
        return new ResponseEntity<>("Order canceled " + orderId, HttpStatus.OK);

    }
    @GetMapping("/userId/{userId}")
    public ResponseEntity<Object> getByUserId(@PathVariable Long userId){
        List<Orders> orders = orderService.getByUserId(userId);
        return new ResponseEntity<>(orders, HttpStatus.OK);

    }
    @GetMapping("/productId/{productId}")
    public ResponseEntity<Object> getByProductId(@PathVariable Long productId){
        List<Orders> orders = orderService.getByProductId(productId);
        return new ResponseEntity<>(orders, HttpStatus.OK);

    }




}

package com.order.service.service;

import com.order.service.dto.OrderDto;
import com.order.service.entity.Orders;

import java.util.List;

public interface OrderService {
    Orders addOrder(OrderDto orderDto);

    List<Orders> getAllOrder();

    Orders getOrderById(Long orderId);

    Orders updateOrder(Long orderId, OrderDto orderDto);

    void cancelOrder(Long orderId);


}

package com.order.service.service;

import com.order.service.dto.OrderDto;
import com.order.service.entity.Orders;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    Orders addOrder(OrderDto orderDto);

    List<Orders> getAllOrder();

    Orders getOrderById(Long orderId);

    Orders updateOrder(Long orderId, OrderDto orderDto);

    void cancelOrder(Long orderId);

    List<Orders> getByUserId(Long userId);

    List<Orders> getByProductId(Long productId);


}

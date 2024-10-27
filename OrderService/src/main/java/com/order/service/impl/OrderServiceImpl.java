package com.order.service.impl;

import com.order.service.dto.OrderDto;
import com.order.service.entity.Orders;
import com.order.service.exceptions.OrderNotFoundException;
import com.order.service.repository.OrderRepository;
import com.order.service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public Orders addOrder(OrderDto orderDto) {
        Orders orders = new Orders();
        orders.setOrderStatus(orderDto.getOrderStatus());
        orders.setQuantity(orderDto.getQuantity());
        orders.setPrice(orderDto.getPrice());
        orders.setCreateDate(orderDto.getCreateDate());
        orders.setUpdateTime(orderDto.getUpdateTime());
        orders.setProductId(orderDto.getProductId());
        orders.setUserId(orderDto.getUserId());
        return orderRepository.save(orders);

    }

    @Override
    public List<Orders> getAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public Orders getOrderById(Long orderId) {
        Orders orders = orderRepository.findById(orderId).
                orElseThrow(()-> new OrderNotFoundException("Order Id not found : " + orderId));
    }

    @Override
    public Orders updateOrder(Long orderId, OrderDto orderDto) {
        Optional<Orders> orders1 = orderRepository.findById(orderId);
        if (orders1.isPresent()){
            Orders orders = orders1.get();
        }
        return null;
    }

    @Override
    public void cancelOrder(Long orderId) {

    }
}

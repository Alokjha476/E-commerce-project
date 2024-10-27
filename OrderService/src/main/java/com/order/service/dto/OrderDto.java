package com.order.service.dto;

import com.order.service.enums.OrderStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class OrderDto {
    private Long orderId;
    private Double price;
    private int quantity;
    private LocalDateTime createDate;
    private LocalDateTime updateTime;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    private Long userId;
    private Long productId;
}


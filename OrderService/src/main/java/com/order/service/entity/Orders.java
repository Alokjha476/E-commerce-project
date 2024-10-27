package com.order.service.entity;

import com.order.service.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
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

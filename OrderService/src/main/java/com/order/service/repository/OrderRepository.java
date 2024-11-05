package com.order.service.repository;

import com.order.service.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {
    @Query(value = "SELECT * FROM orders where product_id = :productId", nativeQuery = true)
    List<Orders> findAllByProductId(@Param("productId") Long productId);
    @Query("SELECT o FROM Orders o WHERE o.userId = :userId")
    List<Orders> findAllByUserId(@Param("userId") Long userId);

}

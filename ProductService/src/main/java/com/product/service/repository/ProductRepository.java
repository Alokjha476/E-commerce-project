package com.product.service.repository;

import com.product.service.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT * from Product where name = :name", nativeQuery = true)
    List<Product> findBytName(@Param("name") String name);

    @Query(value = "SELECT * from Product where category = :category", nativeQuery = true)
    List<Product> findByCategory(@Param("category") String category);

    @Query(value = "DELETE from Product where name = :name ", nativeQuery = true)
    void deleteByName(@Param("name") String name);

    List<Product> findByUserId(Long userId);


}

package com.product.service.service;

import com.product.service.dto.ProductDto;
import com.product.service.entity.Product;

import java.util.List;
import java.util.Optional;


public interface ProductService {

    Product addproduct(ProductDto productDto);

    List<Product> getAllProduct();

    Optional<Product> getProductById(Long id);

    List<Product> getByProductName(String name);

    Product updateProduct(Long id, ProductDto productDto);

    void deleteProduct(Long id);

    void deleteProductByName(String name);

    List<Product> findByCategoryName(String categoryName);

    List<Product> getByProductsOfUser(Long userId);


}

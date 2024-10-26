package com.product.service.serviceImpl;

import com.product.service.dto.ProductDto;
import com.product.service.entity.Product;
import com.product.service.exceptions.ProductNotFoundException;
import com.product.service.repository.ProductRepository;
import com.product.service.service.ProductService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product addproduct(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setCategory(productDto.getCategory());
        product.setPrice(productDto.getPrice());
        product.setQuantity(productDto.getQuantity());
        product.setCreatedDate(productDto.getCreatedDate());
        product.setUpdateDate(productDto.getUpdateDate());
        product.setImageUrl(productDto.getImageUrl());
        product.setDescription(productDto.getDescription());
        product.setUserId(productDto.getUserId());
        return productRepository.save(product);

    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            Product product1 = product.get();
            return product;
        } else {
            throw new ProductNotFoundException("Product id not found : " + id);
        }
    }

    @Override
    public List<Product> getByProductName(String name) {
        return productRepository.findBytName(name);

    }

    @Override
    public Product updateProduct(Long id, ProductDto productDto) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();

            // Check each field from productDto and update only if it's not null
            if (productDto.getName() != null) {
                product.setName(productDto.getName());
            }
            if (productDto.getCategory() != null) {
                product.setCategory(productDto.getCategory());
            }
            if (productDto.getPrice() != null) {
                product.setPrice(productDto.getPrice());
            }
            if (productDto.getQuantity() != null) {
                product.setQuantity(productDto.getQuantity());
            }
            if (productDto.getCreatedDate() != null) {
                product.setCreatedDate(productDto.getCreatedDate());
            }
            if (productDto.getUpdateDate() != null) {
                product.setUpdateDate(productDto.getUpdateDate());
            }
            if (productDto.getImageUrl() != null) {
                product.setImageUrl(productDto.getImageUrl());
            }
            if (productDto.getDescription() != null) {
                product.setDescription(productDto.getDescription());
            }
            if (productDto.getUserId() != null) {
                product.setUserId(productDto.getUserId());
            }
            return productRepository.save(product);
        }
        return null;
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);

    }

    @Override
    public void deleteProductByName(String name) {
        productRepository.deleteByName(name);

    }

    @Override
    public List<Product> findByCategoryName(String categoryName) {
        return productRepository.findByCategory(categoryName);
    }


    @Override
    public List<Product> getByProductsOfUser(Long userId) {
        return productRepository.findByUserId(userId);
    }
}

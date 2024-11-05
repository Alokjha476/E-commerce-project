package com.product.service.controller;

import com.product.service.dto.ProductDto;
import com.product.service.entity.Product;
import com.product.service.service.ProductService;
import org.hibernate.query.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addProduct(@RequestBody ProductDto productDto) {
        Product product = productService.addproduct(productDto);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<Object> getAll() {
        List<Product> products = productService.getAllProduct();
        return new ResponseEntity<>(products, HttpStatus.OK);

    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id) {
        Optional<Product> product = productService.getProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/getByProductName/{name}")
    public ResponseEntity<Object> getByProductName(@PathVariable String name) {
        List<Product> product = productService.getByProductName(name);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/categoryName/{category}")
    public ResponseEntity<Object> getByCategoryName(@PathVariable String category) {
        List<Product> productList = productService.findByCategoryName(category);
        return new ResponseEntity<>(productList, HttpStatus.OK);

    }


    @GetMapping("/getByUserId/{userId}")
    public ResponseEntity<Object> getProductByUserId(@PathVariable Long userId) {
        List<Product> products = productService.getByProductsOfUser(userId);
        return new ResponseEntity<>(products, HttpStatus.OK);

    }

    // update partially and specific field
    @PatchMapping("/update/{productId}")
    public ResponseEntity<Object> updateProduct(@PathVariable Long productId, @RequestBody ProductDto productDto) {
        Product product = productService.updateProduct(productId, productDto);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<Object> deleteProductById(@PathVariable Long productId) {
        productService.deleteProduct(productId);
        return new ResponseEntity<>("Product deleted : " + productId, HttpStatus.OK);

    }


}

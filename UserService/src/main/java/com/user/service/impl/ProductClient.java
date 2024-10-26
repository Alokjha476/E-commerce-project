package com.user.service.impl;

import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

@FeignClient(url = "http://localhost:8082", value = "Product-Client")
public interface ProductClient {

    List<Product> getProductUser();
}

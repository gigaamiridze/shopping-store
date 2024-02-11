package com.workshop.productservice.service;

import com.workshop.productservice.dto.ApiResponse;
import com.workshop.productservice.dto.ProductDto;
import org.springframework.http.ResponseEntity;

public interface ProductService {
    ResponseEntity<ApiResponse> createProduct(ProductDto productDto);
}

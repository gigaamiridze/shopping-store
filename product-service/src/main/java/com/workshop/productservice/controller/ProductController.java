package com.workshop.productservice.controller;

import com.workshop.productservice.dto.ApiResponse;
import com.workshop.productservice.dto.ProductDto;
import com.workshop.productservice.service.impl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductServiceImpl productService;

    @PostMapping
    public ResponseEntity<ApiResponse> createProduct(@RequestBody ProductDto productDto) {
        return productService.createProduct(productDto);
    }
}

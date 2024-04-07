package com.workshop.productservice.controller;

import com.workshop.productservice.dto.ProductDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/v1/product")
public interface ProductController {

    @PostMapping("/create")
    ResponseEntity<ProductDto> createProduct(@Valid @RequestBody ProductDto productDto);

    @GetMapping("/{productId}")
    ResponseEntity<ProductDto> getProductById(@PathVariable Long productId);
}

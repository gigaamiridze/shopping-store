package com.workshop.productservice.service.impl;

import com.workshop.productservice.dto.ApiResponse;
import com.workshop.productservice.dto.ProductDto;
import com.workshop.productservice.mapper.ProductMapper;
import com.workshop.productservice.model.Product;
import com.workshop.productservice.repository.ProductRepository;
import com.workshop.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ResponseEntity<ApiResponse> createProduct(ProductDto productDto) {
        try {
            Product product = productMapper.mapToEntity(productDto);
            Product createdProduct = productRepository.save(product);
            log.info("Product with ID {} is created", createdProduct.getId());
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(new ApiResponse(true, "Product created successfully", createdProduct));
        } catch (Exception e) {
            log.error("Error creating product");
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(false, "Error creating product", null));
        }
    }
}

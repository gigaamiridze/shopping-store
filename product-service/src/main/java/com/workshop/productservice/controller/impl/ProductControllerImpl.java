package com.workshop.productservice.controller.impl;

import com.workshop.productservice.controller.ProductController;
import com.workshop.productservice.dto.ProductDto;
import com.workshop.productservice.entity.Product;
import com.workshop.productservice.mapper.ProductMapper;
import com.workshop.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductControllerImpl implements ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public ResponseEntity<ProductDto> createProduct(ProductDto productDto) {
        Product product = productMapper.mapToEntity(productDto);
        Product productResponse = productService.createProduct(product);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(productMapper.mapToDto(productResponse));
    }

    @Override
    public ResponseEntity<ProductDto> getProductById(Long productId) {
        Product product = productService.getProductById(productId);
        return ResponseEntity.ok(productMapper.mapToDto(product));
    }

    @Override
    public ResponseEntity<List<ProductDto>> getAllProduct() {
        List<Product> products = productService.getAllProduct();
        List<ProductDto> productDtos = products.stream().map(product -> productMapper.mapToDto(product)).toList();
        return ResponseEntity.ok(productDtos);
    }
}

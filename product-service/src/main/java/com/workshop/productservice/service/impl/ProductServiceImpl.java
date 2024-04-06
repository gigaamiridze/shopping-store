package com.workshop.productservice.service.impl;

import com.workshop.productservice.entity.Product;
import com.workshop.productservice.repository.ProductRepository;
import com.workshop.productservice.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        Product savedProduct = productRepository.save(product);
        log.info("Saved new product: {}", savedProduct);
        return savedProduct;
    }
}

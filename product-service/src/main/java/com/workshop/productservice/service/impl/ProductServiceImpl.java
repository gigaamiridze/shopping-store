package com.workshop.productservice.service.impl;

import com.workshop.productservice.entity.Product;
import com.workshop.productservice.repository.ProductRepository;
import com.workshop.productservice.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

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

    @Override
    public Product getProductById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new NoSuchElementException("Product not found with id: " + productId));
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }
}

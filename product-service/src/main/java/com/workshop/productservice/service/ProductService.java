package com.workshop.productservice.service;

import com.workshop.productservice.entity.Product;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product);

    Product getProductById(Long productId);

    List<Product> getAllProduct();
}

package com.workshop.productservice.mapper;

import com.workshop.productservice.dto.ProductDto;
import com.workshop.productservice.model.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {
    public ProductDto mapToDto(Product product) {
        ProductDto productDto = new ProductDto(product.getName(), product.getDescription(), product.getPrice());
        return productDto;
    }

    public Product mapToEntity(ProductDto productDto) {
        Product product = Product.builder()
                .name(productDto.getName())
                .description(productDto.getDescription())
                .price(productDto.getPrice())
                .build();
        return product;
    }
}

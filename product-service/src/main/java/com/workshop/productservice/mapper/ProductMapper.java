package com.workshop.productservice.mapper;

import com.workshop.productservice.dto.ProductDto;
import com.workshop.productservice.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public abstract class ProductMapper {

    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "price", source = "price")
    public abstract ProductDto mapToDto(Product product);

    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "price", source = "price")
    public abstract Product mapToEntity(ProductDto productDto);
}

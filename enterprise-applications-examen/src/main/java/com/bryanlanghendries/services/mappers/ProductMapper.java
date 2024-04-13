package com.bryanlanghendries.services.mappers;

import com.bryanlanghendries.repository.entities.ProductEntity;
import org.openapitools.model.ProductDB;

public interface ProductMapper {

    void addProductEntityToProductDtoMapping();

    ProductDB toProductDto(ProductEntity product);

}

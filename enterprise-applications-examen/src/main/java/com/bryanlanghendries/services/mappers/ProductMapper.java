package com.bryanlanghendries.services.mappers;

import com.bryanlanghendries.repository.entities.ProductEntity;
import org.openapitools.model.ProductDto;
import org.openapitools.model.ProductInput;

public interface ProductMapper {

    ProductDto toProductDto(ProductEntity product);

    ProductEntity toProductEntity(ProductDto product);

    ProductEntity toProductEntity(ProductInput product);

}

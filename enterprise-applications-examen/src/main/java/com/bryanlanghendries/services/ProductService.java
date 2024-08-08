package com.bryanlanghendries.services;

import com.bryanlanghendries.exceptions.EntityNotFoundException;
import com.bryanlanghendries.repository.entities.ProductEntity;
import org.openapitools.model.ProductDto;
import org.openapitools.model.ProductInput;

import java.util.List;

public interface ProductService {

    List<ProductDto> getAllProducts(String category);

    ProductEntity getByIdOrThrowError(int id) throws EntityNotFoundException;

    ProductDto getById(int id);

    void addProduct(ProductInput productInput);

    void deleteProduct(int id);

    void updateProduct(ProductDto product, int id);
}

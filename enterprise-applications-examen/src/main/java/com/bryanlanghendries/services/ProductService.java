package com.bryanlanghendries.services;

import com.bryanlanghendries.exceptions.EntityNotFoundException;
import com.bryanlanghendries.repository.entities.ProductEntity;
import org.openapitools.model.ProductDB;
import org.openapitools.model.ProductInput;

import java.util.List;

public interface ProductService {

    List<ProductDB> getAllProducts();

    ProductEntity getByIdOrThrowError(int id) throws EntityNotFoundException;

    ProductDB getById(int id);
    void addProduct(ProductInput productInput);

    void deleteProduct(int id);

    void updateProduct(ProductInput productInput, int id);
}

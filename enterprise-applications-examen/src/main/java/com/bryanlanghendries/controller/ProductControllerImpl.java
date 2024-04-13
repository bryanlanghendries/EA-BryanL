package com.bryanlanghendries.controller;

import com.bryanlanghendries.services.ProductServiceImpl;
import org.openapitools.api.ProductsApi;
import org.openapitools.model.ProductDB;
import org.openapitools.model.ProductInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductControllerImpl implements ProductsApi {

    private final ProductServiceImpl productService;

    @Autowired
    public ProductControllerImpl(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @Override
    public ResponseEntity<Void> createProduct(ProductInput productInput) {
        productService.addProduct(productInput);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> deleteProductById(Integer id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<List<ProductDB>> getAllProducts(String category) {

       return ResponseEntity.ok(productService.getAllProducts());
    }

    @Override
    public ResponseEntity<ProductDB> getProductById(Integer id) {
        return ResponseEntity.ok(productService.getById(id));
    }

    @Override
    public ResponseEntity<Void> updateProductById(Integer id, ProductInput productInput) {
        productService.updateProduct(productInput, id);
        return ResponseEntity.ok().build();
    }
}

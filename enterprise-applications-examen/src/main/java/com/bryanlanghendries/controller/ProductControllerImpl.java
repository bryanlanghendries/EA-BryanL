package com.bryanlanghendries.controller;

import com.bryanlanghendries.enums.ProductCategory;
import com.bryanlanghendries.services.ProductService;
import org.openapitools.api.ProductsApi;
import org.openapitools.model.ProductDto;
import org.openapitools.model.ProductInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductControllerImpl implements ProductsApi {

    private final ProductService productService;

    @Autowired
    public ProductControllerImpl(ProductService productService) {
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
    public ResponseEntity<List<ProductDto>> getAllProducts(String category) {

       return ResponseEntity.ok(productService.getAllProducts(category));
    }

    @Override
    public ResponseEntity<ProductDto> getProductById(Integer id) {
        return ResponseEntity.ok(productService.getById(id));
    }

    @Override
    public ResponseEntity<Void> updateProductById(Integer id, ProductDto product) {
        productService.updateProduct(product, id);
        return ResponseEntity.ok().build();
    }
}

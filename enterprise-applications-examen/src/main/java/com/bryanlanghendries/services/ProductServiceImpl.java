package com.bryanlanghendries.services;

import com.bryanlanghendries.exceptions.BadInputException;
import com.bryanlanghendries.exceptions.EntityNotFoundException;
import com.bryanlanghendries.repository.database.DbProductEntityRepository;
import com.bryanlanghendries.repository.entities.ProductEntity;
import com.bryanlanghendries.services.mappers.ProductMapper;
import org.openapitools.model.ProductDB;
import org.openapitools.model.ProductInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    private final DbProductEntityRepository productRepository;

    private final ProductMapper mapper;

    @Autowired
    public ProductServiceImpl(DbProductEntityRepository productRepository, ProductMapper mapper){
        this.productRepository = productRepository;
        this.mapper = mapper;
    }
    @Override
    public List<ProductDB> getAllProducts() {
        return null;
    }

    @Override
    public ProductEntity getByIdOrThrowError(int id) throws EntityNotFoundException {
        return null;
    }

    @Override
    public ProductDB getById(int id) {
        return null;
    }

    @Override
    public void addProduct(ProductInput productInput) throws BadInputException {
        try {
            ProductEntity product = new ProductEntity(
                    productInput.getName(),
                    productInput.getCategory(),
                    productInput.getPrice(),
                    productInput.getDescription()
            );
            productRepository.save(product);
        } catch (RuntimeException ex) {
            throw new BadInputException(ProductEntity.class);
        }

    }

    @Override
    public void deleteProduct(int id) {

    }

    @Override
    public void updateProduct(ProductInput productInput, int id) {

    }
}

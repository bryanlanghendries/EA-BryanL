package com.bryanlanghendries.services;

import com.bryanlanghendries.enums.ProductCategory;
import com.bryanlanghendries.exceptions.BadInputException;
import com.bryanlanghendries.exceptions.EntityNotFoundException;
import com.bryanlanghendries.repository.database.DbProductEntityRepository;
import com.bryanlanghendries.repository.entities.ProductEntity;
import com.bryanlanghendries.services.mappers.ProductMapper;
import org.openapitools.model.ProductDto;
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
    public List<ProductDto> getAllProducts(String category) {
        return productRepository.findAll().stream()
                .filter(product -> {
                    if (category == null) return true;
                    try {
                        ProductCategory productCategoryEnum = ProductCategory.valueOf(category.toUpperCase());
                        return product.getCategory() == productCategoryEnum;
                    } catch (IllegalArgumentException e) {
                        return false;
                    }
                })
                .map(mapper::toProductDto)
                .toList();
    }


    @Override
    public ProductEntity getByIdOrThrowError(int id) throws EntityNotFoundException {
        return productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(ProductEntity.class, String.valueOf(id)));
    }

    @Override
    public ProductDto getById(int id) {
        return mapper.toProductDto(getByIdOrThrowError(id));
    }

    @Override
    public void addProduct(ProductInput productInput) throws BadInputException {
        productRepository.save(mapper.toProductEntity(productInput));
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.delete(getByIdOrThrowError(id));
    }

    @Override
    public void updateProduct(ProductDto product, int id) {
        getByIdOrThrowError(id);
        productRepository.save(mapper.toProductEntity(product));
    }
}

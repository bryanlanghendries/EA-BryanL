package com.bryanlanghendries.services.mappers;

import com.bryanlanghendries.repository.entities.ProductEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.openapitools.model.ProductDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class ProductMapperImpl implements ProductMapper{

    private final ModelMapper modelMapper;

    @Autowired
    public ProductMapperImpl(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    public void init(){ addProductEntityToProductDtoMapping(); }
    @Override
    public void addProductEntityToProductDtoMapping() {
        final TypeMap<ProductEntity, ProductDB> typeMap = this.modelMapper.createTypeMap(ProductEntity.class, ProductDB.class);

        typeMap.addMapping(ProductEntity::getId, ProductDB::setId);
        typeMap.addMapping(ProductEntity::getName, ProductDB::setName);
        typeMap.addMapping(ProductEntity::getCategory, ProductDB::setCategory);
        typeMap.addMapping(ProductEntity::getPrice, ProductDB::setPrice);
        typeMap.addMapping(ProductEntity::getDescription, ProductDB::setDescription);
    }

    @Override
    public ProductDB toProductDto(ProductEntity product) { return modelMapper.map(product, ProductDB.class); }
}

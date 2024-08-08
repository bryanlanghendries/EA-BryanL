package com.bryanlanghendries.services.mappers;

import com.bryanlanghendries.repository.entities.ProductEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.openapitools.model.ProductDto;
import org.openapitools.model.ProductInput;
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
        final TypeMap<ProductEntity, ProductDto> typeMap = this.modelMapper.createTypeMap(ProductEntity.class, ProductDto.class);

        typeMap.addMapping(ProductEntity::getId, ProductDto::setId);
        typeMap.addMapping(ProductEntity::getName, ProductDto::setName);
        typeMap.addMapping(ProductEntity::getCategory, ProductDto::setCategory);
        typeMap.addMapping(ProductEntity::getPrice, ProductDto::setPrice);
        typeMap.addMapping(ProductEntity::getDescription, ProductDto::setDescription);
    }

    @Override
    public ProductEntity toProductEntity(ProductInput product) {
        return modelMapper.map(product, ProductEntity.class);
    }

    @Override
    public ProductEntity toProductEntity(ProductDto product) {
        return modelMapper.map(product, ProductEntity.class);
    }

    @Override
    public ProductDto toProductDto(ProductEntity product) { return modelMapper.map(product, ProductDto.class); }
}

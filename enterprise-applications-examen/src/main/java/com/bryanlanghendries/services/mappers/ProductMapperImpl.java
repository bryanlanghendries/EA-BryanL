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

    // This method maps the ProductInput to the ProductEntity
    @Override
    public ProductEntity toProductEntity(ProductInput product) {
        return modelMapper.map(product, ProductEntity.class);
    }

    // This method maps the ProductEntity to the ProductDto
    @Override
    public ProductEntity toProductEntity(ProductDto product) {
        return modelMapper.map(product, ProductEntity.class);
    }

    // This method maps the ProductDto to the ProductEntity
    @Override
    public ProductDto toProductDto(ProductEntity product) { return modelMapper.map(product, ProductDto.class); }
}

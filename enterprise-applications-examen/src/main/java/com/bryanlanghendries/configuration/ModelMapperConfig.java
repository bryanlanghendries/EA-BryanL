package com.bryanlanghendries.configuration;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    private ModelMapper modelMapper;

    // ModelMapper is a library that maps objects to other objects
    @Bean
    public ModelMapper modelMapper(){
        if (modelMapper == null){
            modelMapper = new ModelMapper();
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        }
        return modelMapper;
    }
}

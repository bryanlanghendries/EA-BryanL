package com.bryanlanghendries.services.mappers;

import com.bryanlanghendries.repository.entities.UserEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.openapitools.model.UserDto;
import org.openapitools.model.UserInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class UserMapperImpl implements UserMapper{

    private final ModelMapper modelMapper;

    @Autowired
    public UserMapperImpl(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    // This method maps the UserDto to the UserEntity
    @Override
    public UserEntity toUserEntity(UserDto user) {
        return modelMapper.map(user, UserEntity.class);
    }

    // This method maps the UserEntity to the UserDto
    @Override
    public UserDto toUserDto(UserEntity user) {
        return modelMapper.map(user, UserDto.class);
    }
}

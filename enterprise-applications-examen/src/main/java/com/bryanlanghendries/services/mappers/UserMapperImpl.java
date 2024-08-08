package com.bryanlanghendries.services.mappers;

import com.bryanlanghendries.repository.entities.UserEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.openapitools.model.UserDto;
import org.openapitools.model.UserInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class UserMapperImpl implements UserMapper{

    private final ModelMapper modelMapper;

    @Autowired
    public UserMapperImpl(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    public void init(){ addUserEntityToUserDtoMapping(); }

    @Override
    public void addUserEntityToUserDtoMapping() {
        final TypeMap<UserEntity, UserDto> typeMap = this.modelMapper.createTypeMap(UserEntity.class, UserDto.class);

        typeMap.addMapping(UserEntity::getId, UserDto::setId);
        typeMap.addMapping(UserEntity::getFirstName, UserDto::setFirstName);
        typeMap.addMapping(UserEntity::getLastName, UserDto::setLastName);
        typeMap.addMapping(UserEntity::getEmail, UserDto::setEmail);
        typeMap.addMapping(UserEntity::getPassword, UserDto::setPassword);
    }

    @Override
    public UserEntity toUserEntity(UserDto user) {
        return modelMapper.map(user, UserEntity.class);
    }

    @Override
    public UserDto toUserDto(UserEntity user) {
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public UserEntity toUserEntity(UserInput user) {
        return modelMapper.map(user, UserEntity.class);
    }
}

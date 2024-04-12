package com.bryanlanghendries.services.mappers;

import com.bryanlanghendries.repository.entities.UserEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.openapitools.model.UserDB;
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
        final TypeMap<UserEntity, UserDB> typeMap = this.modelMapper.createTypeMap(UserEntity.class, UserDB.class);

        typeMap.addMapping(UserEntity::getId, UserDB::setId);
        typeMap.addMapping(UserEntity::getFirstName, UserDB::setFirstName);
        typeMap.addMapping(UserEntity::getLastName, UserDB::setLastName);
        typeMap.addMapping(UserEntity::getEmail, UserDB::setEmail);
        typeMap.addMapping(UserEntity::getPassword, UserDB::setPassword);
    }

    @Override
    public UserDB toUserDto(UserEntity user) {
        return modelMapper.map(user, UserDB.class);
    }
}

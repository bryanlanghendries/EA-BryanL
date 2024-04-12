package com.bryanlanghendries.services.mappers;

import com.bryanlanghendries.repository.entities.UserEntity;
import org.openapitools.model.UserDB;
import org.springframework.stereotype.Service;

@Service
public class UserMapperImpl implements UserMapper{

    @Override
    public void addUserEntityToUserDtoMapping() {

    }

    @Override
    public UserDB toUserDto(UserEntity user) {
        return null;
    }
}

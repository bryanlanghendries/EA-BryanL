package com.bryanlanghendries.services.mappers;

import com.bryanlanghendries.repository.entities.UserEntity;
import org.openapitools.model.UserDB;

public interface UserMapper {

    void addUserEntityToUserDtoMapping();
    UserDB toUserDto(UserEntity user);
}

package com.bryanlanghendries.services.mappers;

import com.bryanlanghendries.repository.entities.UserEntity;
import org.openapitools.model.UserDto;
import org.openapitools.model.UserInput;

public interface UserMapper {

    void addUserEntityToUserDtoMapping();
    UserDto toUserDto(UserEntity user);

    UserEntity toUserEntity(UserInput user);
    UserEntity toUserEntity(UserDto user);
}

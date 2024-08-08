package com.bryanlanghendries.services;

import com.bryanlanghendries.exceptions.EntityNotFoundException;
import com.bryanlanghendries.repository.entities.UserEntity;
import org.openapitools.model.UserDto;
import org.openapitools.model.UserInput;

import java.util.Optional;

public interface UserService {
    void addUser(UserInput userInput);

    void updateUser(UserDto user, int id);

    void deleteUser(int id);

    UserEntity getByIdOrThrowError(int id) throws EntityNotFoundException;

    UserDto getById(int id);
}

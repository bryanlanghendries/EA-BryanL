package com.bryanlanghendries.services;

import com.bryanlanghendries.exceptions.EntityNotFoundException;
import com.bryanlanghendries.repository.entities.UserEntity;
import org.openapitools.model.UserDB;
import org.openapitools.model.UserInput;

import java.util.Optional;

public interface UserService {
    void addUser(UserInput userInput);

    void updateUser(UserInput userInput, int id);

    void deleteUser(int id);
    UserDB getById(int id);

    UserEntity getByIdOrThrowError(int id) throws EntityNotFoundException;
}

package com.bryanlanghendries.services;

import com.bryanlanghendries.repository.entities.UserEntity;
import org.openapitools.model.UserDB;
import org.openapitools.model.UserInput;

import java.util.Optional;

public interface UserService {
    void addUser(UserInput userInput);

    UserDB getById(int id);
}

package com.bryanlanghendries.controller;

import org.openapitools.api.UsersApi;
import org.openapitools.model.UserDB;
import org.openapitools.model.UserInput;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserControllerImpl implements UsersApi {
    @Override
    public ResponseEntity<Void> createUser(UserInput userInput) {
        return UsersApi.super.createUser(userInput);
    }

    @Override
    public ResponseEntity<UserInput> deleteUserById(Integer id) {
        return UsersApi.super.deleteUserById(id);
    }

    @Override
    public ResponseEntity<UserDB> getUserById(Integer id) {
        return UsersApi.super.getUserById(id);
    }

    @Override
    public ResponseEntity<UserInput> updateUserById(Integer id) {
        return UsersApi.super.updateUserById(id);
    }
}

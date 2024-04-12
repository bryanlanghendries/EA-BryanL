package com.bryanlanghendries.controller;

import com.bryanlanghendries.services.UserServiceImpl;
import org.openapitools.api.UsersApi;
import org.openapitools.model.UserDB;
import org.openapitools.model.UserInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserControllerImpl implements UsersApi {
    private final UserServiceImpl userService;

    @Autowired
    public UserControllerImpl(UserServiceImpl userService){
        this.userService = userService;
    }
    @Override
    public ResponseEntity<Void> createUser(UserInput userInput) {
        userService.addUser(userInput);
        return ResponseEntity.ok().build();
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

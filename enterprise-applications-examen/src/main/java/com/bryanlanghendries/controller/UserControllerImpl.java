package com.bryanlanghendries.controller;

import com.bryanlanghendries.services.UserServiceImpl;
import org.openapitools.api.UsersApi;
import org.openapitools.model.UserDto;
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
    public ResponseEntity<Void> deleteUserById(Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();

    }

    @Override
    public ResponseEntity<UserDto> getUserById(Integer id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    @Override
    public ResponseEntity<Void> updateUserById(Integer id, UserDto user) {
        userService.updateUser(user, id);
        return ResponseEntity.ok().build();
    }
}

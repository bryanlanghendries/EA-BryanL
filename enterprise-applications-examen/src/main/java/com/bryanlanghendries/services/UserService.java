package com.bryanlanghendries.services;

import com.bryanlanghendries.exceptions.EntityNotFoundException;
import com.bryanlanghendries.repository.entities.UserEntity;
import org.openapitools.model.AdminInput;
import org.openapitools.model.UserDto;
import org.openapitools.model.UserInput;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserService extends UserDetailsService {
    void addUser(UserInput userInput);

    void createAdmin(AdminInput adminInput);

    void updateUser(UserDto user, int id);

    void deleteUser(int id);

    UserEntity getByIdOrThrowError(int id) throws EntityNotFoundException;

    UserEntity getByEmail(String email);

    UserDto getById(int id);

    UserEntity getByEmailOrThrowError(String email) throws EntityNotFoundException;
}

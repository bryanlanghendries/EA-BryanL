package com.bryanlanghendries.services;

import com.bryanlanghendries.repository.database.DbUserEntityRepository;
import com.bryanlanghendries.repository.entities.UserEntity;
import com.bryanlanghendries.services.mappers.UserMapper;
import org.openapitools.model.UserDB;
import org.openapitools.model.UserInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    private final DbUserEntityRepository userRepository;
    private final UserMapper mapper;
    @Autowired
    public UserServiceImpl(DbUserEntityRepository userRepository, UserMapper mapper){
        this.userRepository = userRepository;
        this.mapper = mapper;
    }
    @Override
    public void addUser(UserInput userInput) {
        UserEntity user = new UserEntity(
                userInput.getFirstName(),
                userInput.getLastName(),
                userInput.getEmail(),
                userInput.getPassword(),
                userInput.getIsAdmin()
        );
        userRepository.save(user);
    }

    @Override
    public UserDB getById(int id) {
        return mapper.toUserDto(userRepository.findById(id).get());
    }
}

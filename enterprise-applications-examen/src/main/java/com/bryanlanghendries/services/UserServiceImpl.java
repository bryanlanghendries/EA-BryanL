package com.bryanlanghendries.services;

import com.bryanlanghendries.exceptions.BadInputException;
import com.bryanlanghendries.exceptions.EntityNotFoundException;
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
    public void addUser(UserInput userInput) throws BadInputException {
        try {
            UserEntity user = new UserEntity(
                    userInput.getFirstName(),
                    userInput.getLastName(),
                    userInput.getEmail(),
                    userInput.getPassword(),
                    userInput.getIsAdmin()
            );
            userRepository.save(user);

        } catch (RuntimeException ex) {
            throw new BadInputException(UserEntity.class);
        }

    }

    @Override
    public void updateUser(UserInput userInput, int id) throws BadInputException {
        UserEntity user = getByIdOrThrowError(id);

        try {
            user.setFirstName(userInput.getFirstName());
            user.setLastName(userInput.getLastName());
            user.setEmail(userInput.getEmail());
            user.setPassword(userInput.getPassword());
            user.setAdmin(userInput.getIsAdmin());
            userRepository.save(user);

        } catch (RuntimeException ex) {
            throw new BadInputException(UserEntity.class, String.valueOf(id));
        }
    }

    @Override
    public void deleteUser(int id) { userRepository.delete(getByIdOrThrowError(id)); }

    @Override
    public UserEntity getByIdOrThrowError(int id) throws EntityNotFoundException {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(UserEntity.class, String.valueOf(id)));
    }

    @Override
    public UserDB getById(int id) {
        return mapper.toUserDto(getByIdOrThrowError(id));
    }
}

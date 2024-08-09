package com.bryanlanghendries.services;

import com.bryanlanghendries.exceptions.BadInputException;
import com.bryanlanghendries.exceptions.EntityNotFoundException;
import com.bryanlanghendries.repository.database.DbUserEntityRepository;
import com.bryanlanghendries.repository.entities.UserEntity;
import com.bryanlanghendries.services.mappers.UserMapper;
import org.openapitools.model.AdminInput;
import org.openapitools.model.UserDto;
import org.openapitools.model.UserInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final DbUserEntityRepository userRepository;
    private final UserMapper mapper;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(DbUserEntityRepository userRepository, UserMapper mapper, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public void addUser(UserInput userInput) throws BadInputException {
        try {
            UserEntity user = new UserEntity(
                    userInput.getFirstName(),
                    userInput.getLastName(),
                    userInput.getEmail(),
                    passwordEncoder.encode(userInput.getPassword()),
                    false
            );
            userRepository.save(user);

        } catch (RuntimeException ex) {
            throw new BadInputException(UserEntity.class);
        }

    }

    @Override
    public void createAdmin(AdminInput adminInput) {
        UserEntity admin = new UserEntity(
                adminInput.getFirstName(),
                adminInput.getLastName(),
                adminInput.getEmail(),
                passwordEncoder.encode(adminInput.getPassword()),
                true
        );
        userRepository.save(admin);
    }

    @Override
    public UserEntity getByEmailOrThrowError(String email) throws EntityNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException(UserEntity.class, email));
    }

    @Override
    public UserEntity getByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    @Override
    public void updateUser(UserDto user, int id) throws BadInputException {
        getByIdOrThrowError(id);
        userRepository.save(mapper.toUserEntity(user));
    }

    @Override
    public void deleteUser(int id) { userRepository.delete(getByIdOrThrowError(id)); }

    @Override
    public UserEntity getByIdOrThrowError(int id) throws EntityNotFoundException {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(UserEntity.class, String.valueOf(id)));
    }

    @Override
    public UserDto getById(int id) {
        return mapper.toUserDto(getByIdOrThrowError(id));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}

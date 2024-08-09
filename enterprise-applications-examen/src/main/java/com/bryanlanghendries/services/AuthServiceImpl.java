package com.bryanlanghendries.services;

import com.bryanlanghendries.configuration.JwtConfig;
import com.bryanlanghendries.repository.entities.UserEntity;
import org.openapitools.model.LoginRequest;
import org.openapitools.model.UserInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    private JwtConfig jwtConfig;
    @Autowired
    public AuthServiceImpl(UserService userService, PasswordEncoder passwordEncoder, JwtConfig jwtConfig) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.jwtConfig = jwtConfig;
    }

    @Override
    public String login(LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String rawPassword = loginRequest.getPassword();

        UserEntity user = userService.getByEmailOrThrowError(email);

        if (!passwordEncoder.matches(rawPassword, user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }
        return jwtConfig.generateToken(email);
    }

    @Override
    public void register(UserInput userInput) {

        UserEntity existingUser = userService.getByEmail(userInput.getEmail());
        if (existingUser != null) {
            throw new RuntimeException("User already exists");
        }

        UserInput newUser = new UserInput(
                userInput.getFirstName(),
                userInput.getLastName(),
                userInput.getEmail(),
                passwordEncoder.encode(userInput.getPassword())
        );

        userService.addUser(newUser);

    }
}

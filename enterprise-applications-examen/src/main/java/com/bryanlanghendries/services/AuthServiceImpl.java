package com.bryanlanghendries.services;

import com.bryanlanghendries.configuration.JwtConfig;
import com.bryanlanghendries.repository.entities.UserEntity;
import org.openapitools.model.LoginRequest;
import org.openapitools.model.UserInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private JwtConfig jwtConfig;
    @Autowired
    public AuthServiceImpl(UserService userService, PasswordEncoder passwordEncoder, JwtConfig jwtConfig, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.jwtConfig = jwtConfig;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public String login(LoginRequest loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getEmail(),
                            loginRequest.getPassword()
                    ));


            // Set the authentication object in the SecurityContext
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // Get the authorities from the authentication object
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();


            String jwt = jwtConfig.generateToken(loginRequest.getEmail(), authorities);


            // Generate a JWT token containing the email and authorities
            return jwt;
        } catch (AuthenticationException e) {
            throw new RuntimeException("Invalid username or password", e);
        }
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
                userInput.getPassword()
        );

        userService.addUser(newUser);

    }
}

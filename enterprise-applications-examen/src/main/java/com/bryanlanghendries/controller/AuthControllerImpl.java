package com.bryanlanghendries.controller;

import com.bryanlanghendries.services.AuthService;
import org.openapitools.api.AuthApi;
import org.openapitools.model.LoginRequest;
import org.openapitools.model.UserInput;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class AuthControllerImpl implements AuthApi {

    private final AuthService authService;

    public AuthControllerImpl(AuthService authService) {
        this.authService = authService;
    }
    @Override
    public ResponseEntity<String> login(LoginRequest loginRequest) {
        String token = authService.login(loginRequest);
        return ResponseEntity.ok(token);
    }

    @Override
    public ResponseEntity<Void> register(UserInput userInput) {
        authService.register(userInput);
        return ResponseEntity.ok().build();
    }
}

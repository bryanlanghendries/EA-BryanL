package com.bryanlanghendries.services;

import org.openapitools.model.LoginRequest;
import org.openapitools.model.UserInput;

public interface AuthService {
    String login(LoginRequest loginRequest);

    void register(UserInput userInput);
}

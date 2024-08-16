package com.bryanlanghendries.configuration;

import com.bryanlanghendries.services.UserService;
import org.openapitools.model.AdminInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdminConfig {

    private final UserService userService;

    @Autowired
    public AdminConfig(UserService userService) {
        this.userService = userService;
        createAdmin();
    }

    // Create an admin user if one does not exist
    public void createAdmin() {
        AdminInput admin = new AdminInput(
                "admin",
                "admin",
                "admin@gmail.com",
                "admin",
                true
        );
        if (userService.getByEmail(admin.getEmail()) != null) {
            return;
        }
        userService.createAdmin(admin);
    }
}

package com.payments.walletservice.controller;

import com.payments.walletservice.dto.UserRegistrationRequest;
import com.payments.walletservice.entity.User;
import com.payments.walletservice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for user operations
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    /**
     * The user service
     */
    private final UserService userService;

    /**
     * Create a new user controller
     *
     * @param userService the user service
     */
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Register a new user
     *
     * @param userRegistrationRequest the user registration request
     * @return the registered user
     */
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody UserRegistrationRequest userRegistrationRequest) {
        return ResponseEntity.ok(userService.registerUser(userRegistrationRequest));
    }
}

package com.payments.walletservice.controller;

import com.payments.walletservice.dto.UserRegistrationRequest;
import com.payments.walletservice.entity.User;
import com.payments.walletservice.exceptions.user.UserNotFoundException;
import com.payments.walletservice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    /**
     * Get a user by email
     *
     * @param email the email of the user
     * @return the user
     * @throws UserNotFoundException if the user is not found
     */
    @GetMapping("/get/{email}")
    public ResponseEntity<User> getUser(@PathVariable String email) throws UserNotFoundException {
        return ResponseEntity.ok(userService.getUser(email));
    }
}

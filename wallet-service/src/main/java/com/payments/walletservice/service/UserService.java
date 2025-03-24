package com.payments.walletservice.service;

import com.payments.walletservice.dto.UserRegistrationRequest;
import com.payments.walletservice.entity.User;
import com.payments.walletservice.exceptions.UserExistsException;
import com.payments.walletservice.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service for user operations
 */
@Service
public class UserService {

    /**
     * The user repository
     */
    private final UserRepository userRepository;

    /**
     * Create a new user service
     *
     * @param userRepository the user repository
     */
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Register a new user
     *
     * @param userRegistrationRequest the user registration request
     * @return the registered user
     */
    @Transactional
    public User registerUser(UserRegistrationRequest userRegistrationRequest) {
        if (userRepository.existsByEmail(userRegistrationRequest.email())) {
            throw new UserExistsException("User with email " + userRegistrationRequest.email() + " already exists");
        }

        User user = new User();
        user.setUsername(userRegistrationRequest.username());
        user.setEmail(userRegistrationRequest.email());
        user.setPassword(userRegistrationRequest.password());

        return userRepository.save(user);
    }
}

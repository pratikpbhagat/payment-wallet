package com.payments.walletservice.service;

import com.payments.walletservice.dto.UserRegistrationRequest;
import com.payments.walletservice.entity.User;
import com.payments.walletservice.exceptions.user.UserExistsException;
import com.payments.walletservice.exceptions.user.UserNotFoundException;
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

    /**
     * Get a user by email
     *
     * @param email the email of the user
     * @return the user
     * @throws UserNotFoundException if the user is not found
     */
    public User getUser(String email) throws UserNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException("User with email " + email + " not found"));
    }
}

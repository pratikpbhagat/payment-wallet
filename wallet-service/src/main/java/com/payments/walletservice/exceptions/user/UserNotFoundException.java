package com.payments.walletservice.exceptions.user;

/**
 * Exception thrown when a user is not found
 */
public class UserNotFoundException extends Exception {

    /**
     * Create a new user not found exception
     *
     * @param message the exception message
     */
    public UserNotFoundException(String message) {
        super(message);
    }
}

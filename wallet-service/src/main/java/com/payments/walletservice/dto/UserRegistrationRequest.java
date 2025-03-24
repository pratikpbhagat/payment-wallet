package com.payments.walletservice.dto;

/**
 * A request to register a new user
 */
public record UserRegistrationRequest(String username, String email, String password) {
}

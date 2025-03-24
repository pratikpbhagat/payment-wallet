package com.payments.walletservice.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * A user entity
 */
@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
public class User {

    /**
     * The user ID
     */
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(columnDefinition = "UUID", updatable = false, nullable = false)
    private UUID id;

    /**
     * The user name
     */
    @Column(nullable = false)
    private String username;

    /**
     * The user email
     */
    @Column(nullable = false, unique = true)
    private String email;

    /**
     * The user password
     */
    @Column(nullable = false)
    private String password; // Hashed password

    /**
     * The user creation date
     */
    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}

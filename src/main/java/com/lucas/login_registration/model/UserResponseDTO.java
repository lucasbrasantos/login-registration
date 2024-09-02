package com.lucas.login_registration.model;

public record UserResponseDTO(String username, String password) {
    public UserResponseDTO(User user) {
        this(user.getUsername(), user.getPassword());
    }
}

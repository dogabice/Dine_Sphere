package com.dinesphere.dtos;

import com.dinesphere.entities.UserRole;

public class UserDTO {
    private String username;
    private String password; // Şifre genelde açık bir şekilde tutulmamalıdır, bu sadece örnek için
    private UserRole role; 

    // Getters and Setters

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}

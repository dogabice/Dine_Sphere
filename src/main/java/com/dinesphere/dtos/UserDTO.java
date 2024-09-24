package com.dinesphere.dtos;

public class UserDTO {
    private Long userId;
    private String username;
    private String password; // Şifre genelde açık bir şekilde tutulmamalıdır, bu sadece örnek için

    // Getters and Setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

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
}

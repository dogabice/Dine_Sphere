package com.dinesphere.mappers;

import com.dinesphere.dtos.UserDTO;
import com.dinesphere.entities.User;

public class UserMapper {

    public static UserDTO toDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setUsername(user.getUsername());
        dto.setPassword(user.getPassword()); 
        dto.setRole(user.getRole());
        return dto;
    }

    public static User toEntity(UserDTO dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setRole(dto.getRole());
        return user;
    }
}

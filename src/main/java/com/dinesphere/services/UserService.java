package com.dinesphere.services;

import com.dinesphere.dtos.UserDTO;
import com.dinesphere.entities.User;
import com.dinesphere.mappers.UserMapper;
import com.dinesphere.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO createUser(UserDTO userDTO) {
        User user = UserMapper.toEntity(userDTO);
        User savedUser = userRepository.save(user);
        return UserMapper.toDTO(savedUser);
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                             .map(UserMapper::toDTO)
                             .toList();
    }

    public UserDTO getUserById(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        return user != null ? UserMapper.toDTO(user) : null;
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}

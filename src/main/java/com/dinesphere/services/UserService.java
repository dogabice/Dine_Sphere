package com.dinesphere.services;

import com.dinesphere.dtos.UserDTO;
import com.dinesphere.entities.User;
import com.dinesphere.entities.UserRole;
import com.dinesphere.mappers.UserMapper;
import com.dinesphere.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final PasswordEncoder passwordEncoder; 

    
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDTO createUser(UserDTO userDTO) {
        if (userRepository.count() == 0) {
            userDTO.setRole(UserRole.ADMIN); // İlk kullanıcı admin olmalı
        } else if (userDTO.getRole() == null) {
            userDTO.setRole(UserRole.WAITER); // Diğer kullanıcılar için varsayılan rol
        }
        
        User newUser = UserMapper.toEntity(userDTO);
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        User savedUser = userRepository.save(newUser);
        return UserMapper.toDTO(savedUser);
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                             .map(UserMapper::toDTO)
                             .toList();
    }

    public UserDTO getUserById(Long userId) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + userId));
        return UserMapper.toDTO(user);
    }

    public void deleteUser(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new IllegalArgumentException("User cannot be found: " + userId);
        }
        userRepository.deleteById(userId);
    }

    public UserDTO updateUser(Long userId, UserDTO userDTO) {
        User existingUser = userRepository.findById(userId)
            .orElseThrow(() -> new IllegalArgumentException("User cannot be found: " + userId));
        
        existingUser.setUsername(userDTO.getUsername());

        // Şifreyi yalnızca yeni bir şifre verilmişse güncelle
        if (userDTO.getPassword() != null && !userDTO.getPassword().isEmpty()) {
            existingUser.setPassword(passwordEncoder.encode(userDTO.getPassword())); 
        }

        existingUser.setRole(userDTO.getRole());
    
        User updatedUser = userRepository.save(existingUser);
        return UserMapper.toDTO(updatedUser);
    }
}

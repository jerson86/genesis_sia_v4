package com.genesis.demo.services;

import com.genesis.demo.models.User;
import com.genesis.demo.models.dto.UserResponse;

public interface UserService {
    UserResponse createUser(User user);
    UserResponse getUserById(Long id);
    UserResponse getAllUsers();
    UserResponse editUser(Long id, User user);
    UserResponse deleteUser(Long id);
}

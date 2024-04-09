package com.genesis.demo.services;

import com.genesis.demo.models.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User getUserById(Long id) throws Exception;
    List<User> getAllUsers();
    User editUser(Long id, User user) throws Exception;
    Boolean deleteUser(Long id) throws Exception;
}

package com.genesis.demo.services;

import com.genesis.demo.models.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserServiceImp implements UserService{
    @Override
    public User createUser(User user) {
        return User.builder()
                .fullName("Pepito perez")
                .id(1L)
                .birthDay(LocalDate.parse("2022-02-22"))
                .email("pepito@gmail.com")
                .build();
    }

    @Override
    public User getUserById(Long id) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public User editUser(Long id, User user) {
        return null;
    }

    @Override
    public Boolean deleteUser(Long id) {
        return null;
    }
}

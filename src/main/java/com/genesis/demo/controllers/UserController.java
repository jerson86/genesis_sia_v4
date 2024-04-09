package com.genesis.demo.controllers;

import com.genesis.demo.models.User;
import com.genesis.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/genesis/users")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }
    @GetMapping
    public List<User> listUsers(){
        return userService.getAllUsers();
    }
    @PutMapping("{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) throws Exception {
        return userService.editUser(id, user);
    }
    @DeleteMapping("{id}")
    public Boolean deleteUser(@PathVariable Long id) throws Exception {
        return userService.deleteUser(id);
    }
    @GetMapping("{id}")
    public User getUserById(@PathVariable Long id) throws Exception {
        return userService.getUserById(id);
    }
}

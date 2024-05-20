package com.genesis.demo.controllers;

import com.genesis.demo.models.User;
import com.genesis.demo.models.dto.UserResponse;
import com.genesis.demo.services.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/genesis/users")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody User user){

        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<UserResponse> listUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<UserResponse> updateUser(@NotNull @PathVariable Long id, @Valid @RequestBody User user) {
        return new ResponseEntity<>(userService.editUser(id, user), HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<UserResponse> deleteUser(@NotNull @PathVariable Long id) {
        return new ResponseEntity<>(userService.deleteUser(id), HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<UserResponse> getUserById(@NotNull @PathVariable Long id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }
}

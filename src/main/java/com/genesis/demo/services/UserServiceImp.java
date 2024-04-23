package com.genesis.demo.services;

import com.genesis.demo.enums.ErrorMessage;
import com.genesis.demo.exceptions.AlreadyExistsException;
import com.genesis.demo.exceptions.NotFoundException;
import com.genesis.demo.models.User;
import com.genesis.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        Optional<User> userFindByemail = userRepository.findByEmail(user.getEmail());
        if(userFindByemail.isPresent()){
            throw new AlreadyExistsException(ErrorMessage.USER_EMAIL_EXISTS.getMessage());
        }
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()){
            throw new NotFoundException(ErrorMessage.USER_NOT_FOUND.getMessage());
        }
        return user.get();
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User editUser(Long id, User user) {
        Optional<User> userBd = userRepository.findById(id);
        if(userBd.isEmpty()){
            throw new NotFoundException(ErrorMessage.USER_NOT_FOUND.getMessage());
        }
        Optional<User> userFindByemail = userRepository.findByEmail(user.getEmail());
        if(userFindByemail.isPresent()){
            throw new AlreadyExistsException(ErrorMessage.USER_EMAIL_EXISTS.getMessage());
        }
        userBd.get().setFullName(user.getFullName());
        userBd.get().setBirthDay(user.getBirthDay());
        userBd.get().setEmail(user.getEmail());
        return userBd.get();
    }

    @Override
    public Boolean deleteUser(Long id) {
        Optional<User> userBd = userRepository.findById(id);
        if(userBd.isEmpty()){
            throw new NotFoundException(ErrorMessage.USER_NOT_FOUND.getMessage());
        }
        userRepository.deleteById(id);
        return true;
    }
}

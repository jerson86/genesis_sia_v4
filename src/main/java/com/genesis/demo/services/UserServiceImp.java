package com.genesis.demo.services;

import com.genesis.demo.enums.ErrorMessage;
import com.genesis.demo.enums.MessageResponse;
import com.genesis.demo.exceptions.AlreadyExistsException;
import com.genesis.demo.exceptions.NotFoundException;
import com.genesis.demo.helpers.mappers.UserMapper;
import com.genesis.demo.models.User;
import com.genesis.demo.models.dto.UserResponse;
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
    public UserResponse createUser(User user) {
        Optional<User> userFindByEmail = userRepository.findByEmail(user.getEmail());
        if(userFindByEmail.isPresent()){
            throw new AlreadyExistsException(ErrorMessage.USER_EMAIL_EXISTS.getMessage());
        }
        return UserMapper.userToUserResponse(
                List.of(userRepository.save(user)),
                MessageResponse.USER_CREATED.getMessage()
        );
    }

    @Override
    public UserResponse getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()){
            throw new NotFoundException(ErrorMessage.USER_NOT_FOUND.getMessage());
        }
        return UserMapper.userToUserResponse(
                List.of(user.get()),
                MessageResponse.USER_FOUND.getMessage()
        );
    }

    @Override
    public UserResponse getAllUsers() {
        return UserMapper.userToUserResponse(
                (List<User>) userRepository.findAll(),
                MessageResponse.USER_FOUND.getMessage()
        );
    }

    @Override
    public UserResponse editUser(Long id, User user) {
        Optional<User> userBd = userRepository.findById(id);
        if(userBd.isEmpty()){
            throw new NotFoundException(ErrorMessage.USER_NOT_FOUND.getMessage());
        }
        Optional<User> userFindByEmail = userRepository.findByEmail(user.getEmail());
        if(userFindByEmail.isPresent()){
            throw new AlreadyExistsException(ErrorMessage.USER_EMAIL_EXISTS.getMessage());
        }
        userBd.get().setFullName(user.getFullName());
        userBd.get().setBirthDay(user.getBirthDay());
        userBd.get().setEmail(user.getEmail());

        return UserMapper.userToUserResponse(
                List.of(userBd.get()),
                MessageResponse.USER_UPDATED.getMessage()
        );
    }

    @Override
    public UserResponse deleteUser(Long id) {
        Optional<User> userBd = userRepository.findById(id);
        if(userBd.isEmpty()){
            throw new NotFoundException(ErrorMessage.USER_NOT_FOUND.getMessage());
        }
        userRepository.deleteById(id);

        return UserMapper.userToUserResponse(
                List.of(userBd.get()),
                MessageResponse.USER_DELETED.getMessage()
        );
    }
}

package com.genesis.demo.services;

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
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) throws Exception {
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()){
            throw new Exception("usuario no encontrado");
        }
        return user.get();
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User editUser(Long id, User user) throws Exception {
        Optional<User> userBd = userRepository.findById(id);
        if(userBd.isEmpty()){
            throw new Exception("usuario no encontrado");
        }
        Optional<User> userFindByemail = userRepository.findByEmail(user.getEmail());
        if(userFindByemail.isPresent()){
            throw new Exception("Correo ya registrado");
        }
        userBd.get().setFullName(user.getFullName());
        userBd.get().setBirthDay(user.getBirthDay());
        userBd.get().setEmail(user.getEmail());
        return userBd.get();
    }

    @Override
    public Boolean deleteUser(Long id) throws Exception {
        Optional<User> userBd = userRepository.findById(id);
        if(userBd.isEmpty()){
            throw new Exception("usuario no encontrado");
        }
        userRepository.deleteById(id);
        return true;
    }
}

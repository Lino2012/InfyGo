package com.infygo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infygo.dto.UserDTO;
import com.infygo.entity.User;
import com.infygo.exception.InfyGoException;
import com.infygo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Integer registerUser(UserDTO userDTO) throws InfyGoException {

        Optional<User> optional =
                userRepository.findByEmail(userDTO.getEmail());

        if(optional.isPresent()) {
            throw new InfyGoException("User already registered");
        }

        User user = new User();

        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setCity(userDTO.getCity());
        user.setPhoneNumber(userDTO.getPhoneNumber());

        user = userRepository.save(user);

        return user.getUserId();
    }

    @Override
    public String loginUser(String email, String password)
            throws InfyGoException {

        Optional<User> optional =
                userRepository.findByEmail(email);

        if(optional.isEmpty()) {
            throw new InfyGoException(
                    "Invalid Login Credentials");
        }

        User user = optional.get();

        if(!user.getPassword().equals(password)) {
            throw new InfyGoException(
                    "Invalid Login Credentials");
        }

        return "Login Successful";
    }
}
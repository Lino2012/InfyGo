package com.infygo.service;

import com.infygo.dto.UserDTO;
import com.infygo.exception.InfyGoException;

public interface UserService {

    Integer registerUser(UserDTO userDTO)
            throws InfyGoException;

    String loginUser(String email, String password)
            throws InfyGoException;
}
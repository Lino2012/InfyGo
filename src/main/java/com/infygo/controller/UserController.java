package com.infygo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.infygo.dto.LoginDTO;
import com.infygo.dto.UserDTO;
import com.infygo.exception.InfyGoException;
import com.infygo.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/infygo")
@Tag(
        name = "User APIs",
        description = "Registration and Login Services"
)
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(
            summary = "Register User",
            description = "Registers a new user in InfyGo"
    )
    @PostMapping("/register")
    public String registerUser(
            @Valid @RequestBody UserDTO userDTO)
            throws InfyGoException {

        Integer userId = userService.registerUser(userDTO);

        return "User Registered Successfully. User Id : " + userId;
    }

    @Operation(
            summary = "Login User",
            description = "Authenticates a registered user"
    )
    @PostMapping("/login")
    public String loginUser(
            @Valid @RequestBody LoginDTO loginDTO)
            throws InfyGoException {

        return userService.loginUser(
                loginDTO.getEmail(),
                loginDTO.getPassword());
    }
}
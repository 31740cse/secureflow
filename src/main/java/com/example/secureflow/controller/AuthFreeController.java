package com.example.secureflow.controller;

import com.example.secureflow.dto.UserDTO;
import com.example.secureflow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/home-page")
public class AuthFreeController {

    @Autowired
    UserService userService;

    @PostMapping("/register-user")
    public UserDTO registerUser(@RequestBody UserDTO userDTO){
        userService.register(userDTO);
        return userDTO;
    }
}

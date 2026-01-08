package com.example.secureflow.controller;

import com.example.secureflow.dto.UserDTO;
import com.example.secureflow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("")
    public List<UserDTO> getAllUsers(){
        return  userService.getAllUsersList();
        
    }

    @GetMapping("/me")
    public String getCurrentUserDetails(){
        return "";
    }

}

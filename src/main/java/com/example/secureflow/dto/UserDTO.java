package com.example.secureflow.dto;


import lombok.Data;

@Data
public class UserDTO {
    private String firstName;
    private String lastName;
    private String userName;
    private String passWord;
    private String role;
}

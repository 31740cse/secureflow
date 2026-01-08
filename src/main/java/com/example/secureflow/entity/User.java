package com.example.secureflow.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.boot.model.naming.Identifier;

@Entity
@Data

@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String LastName;
    private String userName;
    private String passWord;
    private String role;
}

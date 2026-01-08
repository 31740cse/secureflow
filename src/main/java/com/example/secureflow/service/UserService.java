package com.example.secureflow.service;

import com.example.secureflow.dto.UserDTO;
import com.example.secureflow.entity.User;
import com.example.secureflow.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;


    public void register(UserDTO userDTO) {
        User userEntityDetails= new User();

        userEntityDetails.setFirstName(userDTO.getFirstName());
        userEntityDetails.setLastName(userDTO.getLastName());
        userEntityDetails.setUserName(userDTO.getUserName());
        userEntityDetails.setPassWord(userDTO.getPassWord());
        userEntityDetails.setRole(userDTO.getRole());
        userRepo.save(userEntityDetails);
    }

    public List<UserDTO> getAllUsersList() {
        List<UserDTO> allUsersList = new ArrayList<>();

        for(User user: userRepo.findAll()){
            UserDTO userDTO= new UserDTO();

            userDTO.setFirstName(userDTO.getUserName());
            userDTO.setLastName(userDTO.getLastName());
            userDTO.setUserName(user.getUserName());
            userDTO.setRole(user.getRole());

            allUsersList.add(userDTO);
        }

        return allUsersList;


    }
}

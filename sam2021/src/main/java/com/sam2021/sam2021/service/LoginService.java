package com.sam2021.sam2021.service;


import com.sam2021.sam2021.models.User;
import com.sam2021.sam2021.repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private UserRepo userRepo;
    

    public boolean validateUser(String email, String password){
        User user = userRepo.findByEmail(email);
        if(user == null){
            return false;
        }
        return user.auth(password);
    }

    public String getAccountType(String email){
        String accountype = userRepo.getEmailAccoutType(email);

        return accountype;
    }
}

package com.sam2021.sam2021.service;



import com.sam2021.sam2021.models.User;
import com.sam2021.sam2021.repository.UserRepo;

import org.apache.commons.codec.digest.DigestUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    
    @Autowired
    private UserRepo userRepo;

    public User findByEmail(String email){
        return userRepo.findByEmail(email);
    }

    public User save(User register){
       
        System.out.print(DigestUtils.md5Hex(register.getPassword()));
        register.setEmail(register.getEmail());
        register.setAccountType(register.getAccountType());
        register.setAffiliation(register.getAffiliation());
        register.setFtname(register.getFtname());
        register.setLtname(register.getLtname());
        register.setPassword(DigestUtils.md5Hex(register.getPassword()));
        register.setPhonenumber(register.getPhonenumber());
        
        return userRepo.save(register);
        
    }
}

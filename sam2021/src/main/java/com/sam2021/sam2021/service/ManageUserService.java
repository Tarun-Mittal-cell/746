package com.sam2021.sam2021.service;

import java.util.List;
import java.util.Optional;

import com.sam2021.sam2021.models.User;
import com.sam2021.sam2021.repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManageUserService {
    
    @Autowired
    private UserRepo userRepo;

    public User findByEmail(String email){
        User user = userRepo.findByEmail(email);
        System.out.print(user);
        return user;
    }

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    public Optional<User> findbyId(Long id){
        return userRepo.findById(id);
    }

    public void update(User user){
        userRepo.save(user);
    }

    public void delete(User user){
        userRepo.delete(user);
    }

    public User save(User register){
    
        register.setEmail(register.getEmail());
        register.setAccountType(register.getAccountType());
        register.setAffiliation(register.getAffiliation());
        register.setFtname(register.getFtname());
        register.setLtname(register.getLtname());
        register.setPassword(register.getPassword());
        register.setPhonenumber(register.getPhonenumber());
        
        return userRepo.save(register);
        
    }
}

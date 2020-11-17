package com.sam2021.sam2021.service;

import java.util.List;
import java.util.Optional;


import com.sam2021.sam2021.models.Topic;
import com.sam2021.sam2021.models.User;
import com.sam2021.sam2021.models.Enums.AccountTypeEnum;
import com.sam2021.sam2021.repository.DeadlineRepo;
import com.sam2021.sam2021.repository.TopicRepo;
import com.sam2021.sam2021.repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManageUserService {
    
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private TopicRepo topicRepo;

    @Autowired
    private DeadlineRepo dRepo;

    public User findByEmail(String email){
        User user = userRepo.findByEmail(email);
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

    public String delete(User user){
        if(user.getAccountType().equals(AccountTypeEnum.Chairman)) {
            List<Topic> topic = topicRepo.findByChairman(user);
            if(topic.isEmpty()){
                userRepo.delete(user);
                return "Delete successful";
            }
            else{
                return "Chairman is current active with one of more Topics";
            }
        }
        else if(user.getAccountType().equals(AccountTypeEnum.Member)){
            userRepo.delete(user);
        }
        return "";

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

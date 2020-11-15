package com.sam2021.sam2021.service;

import java.util.List;

import com.sam2021.sam2021.models.Deadlines;
import com.sam2021.sam2021.models.ReviewTemplate;
import com.sam2021.sam2021.models.Topic;
import com.sam2021.sam2021.models.User;
import com.sam2021.sam2021.repository.DeadlineRepo;
import com.sam2021.sam2021.repository.ReviewTemplateRepo;
import com.sam2021.sam2021.repository.TopicRepo;
import com.sam2021.sam2021.repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateDeadlineService{

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ReviewTemplateRepo rTemplateRepo;

    @Autowired
    private TopicRepo tpRepo;

    public void save(Topic t){   
        // t.setDeadlines(d);
        // d.setTopic(t);
        tpRepo.save(t);
    }

    public List<User> getallchairman(){
        List<User> chairmans = userRepo.getAllChairman();
        return chairmans;
    }

    public List<ReviewTemplate> getAllReviewTemplates(){
        List<ReviewTemplate> reviewTemplates = rTemplateRepo.findAll();
        return reviewTemplates;
    }
}

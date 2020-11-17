package com.sam2021.sam2021.service;

import java.util.List;
import java.util.Optional;

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
public class CreateTopicService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ReviewTemplateRepo rTemplateRepo;

    @Autowired
    private TopicRepo tpRepo;

    public void save(Topic topic, User chairman, ReviewTemplate reviewTemplate, Deadlines deadlines){   
        topic.setChairman(chairman);
        topic.setReviewTemp(reviewTemplate);
        topic.setDeadlines(deadlines);
        deadlines.setTopic(topic);
        tpRepo.save(topic);
    }

    public List<User> getallchairman(){
        List<User> chairmans = userRepo.getAllChairman();
        return chairmans;
    }

    public List<ReviewTemplate> getAllReviewTemplates(){
        List<ReviewTemplate> reviewTemplates = rTemplateRepo.findAll();
        return reviewTemplates;
    }

	public Optional<Topic> findbyId(Long id) {
		return tpRepo.findById(id);
    }
    
    public List<Topic> findByChairman(User chairman) {
        return tpRepo.findByChairman(chairman);
    }
}

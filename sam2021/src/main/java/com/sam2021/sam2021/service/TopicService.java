package com.sam2021.sam2021.service;

import java.util.List;

import com.sam2021.sam2021.models.Topic;
import com.sam2021.sam2021.repository.TopicRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
    
    @Autowired
    private TopicRepo topicRepo;

    public List<Topic> getTopics(){
        return topicRepo.getAll();
    }
}
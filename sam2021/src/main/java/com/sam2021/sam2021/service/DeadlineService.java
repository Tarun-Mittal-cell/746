package com.sam2021.sam2021.service;

import java.util.Optional;

import com.sam2021.sam2021.models.Deadlines;
import com.sam2021.sam2021.models.Topic;
import com.sam2021.sam2021.repository.DeadlineRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeadlineService {

    @Autowired
    private DeadlineRepo deadlineRepo;

    public Optional<Deadlines> findbyId(Long id){
        return deadlineRepo.findById(id);
    }

    public Optional<Deadlines> findbytopic(Topic topic){
        return deadlineRepo.findByTopic(topic);
    }
    
}

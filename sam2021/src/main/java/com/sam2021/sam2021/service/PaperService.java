package com.sam2021.sam2021.service;

import java.util.Optional;

import com.sam2021.sam2021.models.Paper;
import com.sam2021.sam2021.models.User;
import com.sam2021.sam2021.repository.PaperRepo;
import com.sam2021.sam2021.repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaperService {
    @Autowired
    private PaperRepo paperRepo;

    @Autowired
    private UserRepo userRepo;
    
    public void toggleInterested(long userId, long paperId){
        Paper paper = paperRepo.getById(paperId);
        Optional<User> user = userRepo.findById(userId);

        if(paper.getReviewers().contains(user.get())){
            paper.getReviewers().remove(user.get());
        }
        else{
            paper.getReviewers().add(user.get());
        }
    }
}

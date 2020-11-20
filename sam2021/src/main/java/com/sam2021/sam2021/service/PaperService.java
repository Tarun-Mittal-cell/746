package com.sam2021.sam2021.service;

import java.util.List;
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
        User user = userRepo.findById(userId).get();

        if(paper.getReviewers().contains(user)){
            paper.getReviewers().remove(user);
        }
        else{
            paper.getReviewers().add(user);
        }

        paperRepo.save(paper);
    }

    public List<Paper> getByTopic(long topicId){
        return paperRepo.findByTopic(topicId);
    }

    public List<Paper> findByReviewer(long userId){
        return paperRepo.FindAllPapers(userId);
    }

    public Paper findById(long paperId){
        return paperRepo.getById(paperId);
    }
}

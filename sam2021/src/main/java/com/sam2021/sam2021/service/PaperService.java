package com.sam2021.sam2021.service;

import java.util.List;
import java.util.Optional;

import com.sam2021.sam2021.models.Paper;
import com.sam2021.sam2021.models.User;
import com.sam2021.sam2021.models.Topic;
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
        Paper paper = paperRepo.findById(paperId);
        User user = userRepo.findById(userId).get();

        if(paper.getReviewers().contains(user)){
            paper.getReviewers().remove(user);
        }
        else{
            paper.getReviewers().add(user);
        }


        paperRepo.save(paper);
    }

    public List<Paper> findByReviewer(long userId){
        return paperRepo.FindAllPapers(userId);
    }

    public Paper findById(long paperId){
        return paperRepo.findById(paperId);
    }

    public List<Paper> findbytopicFalse(Long id) {
        return paperRepo.findByTopic(id);
    }

    public List<Paper> findByTopic(Long id) {
        return paperRepo.findAllByTopic(id);
    }

    public Paper findByFilename(String filename){
        return paperRepo.findByFilename(filename);
    }

    public Paper save(Paper paper){
        
        return paperRepo.save(paper);
        
    }

    public List<Paper> FindAllPapers(Long id){
        System.out.print(id);
        List<Paper> papers = paperRepo.FindAllPapers(id);
        System.out.print(papers.isEmpty());
        return papers;
    }
    
    public void removnoneassigned(Long paperId, List<User> users){
        Paper paper = paperRepo.findByIdd(paperId);
    
        paper.getReviewers().retainAll(users);
        paper.setAssigned(true);

        paperRepo.save(paper);
    }

}

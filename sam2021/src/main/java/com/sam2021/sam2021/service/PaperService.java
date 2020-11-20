package com.sam2021.sam2021.service;

import java.util.List;
import java.util.Optional;

import com.sam2021.sam2021.models.Paper;
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


    public List<Paper> findbytopicFalse(Long id) {
        return paperRepo.findByTopic(id);
    }

    public Paper findByFilename(String filename){
        return paperRepo.findByFilename(filename);
    }

    public Paper save(Paper paper){
        
        return paperRepo.save(paper);
        
    }

    public List<Paper> FindAllPapers(Long id){
        return paperRepo.FindAllPapers(id);
    }
    

}
package com.sam2021.sam2021.service;

import java.util.List;

import com.sam2021.sam2021.models.ReviewTemplate;
import com.sam2021.sam2021.repository.ReviewTemplateRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ReviewTemplateService {

    @Autowired
    private ReviewTemplateRepo tRepo;

    public List<ReviewTemplate> getAll(){
        return tRepo.findAll();
    }

    public ReviewTemplate findByfilename(String filename){
        return tRepo.findByFilename(filename);
    }

    public ReviewTemplate save( String filename){

        ReviewTemplate rTemplate = new ReviewTemplate(filename);
        return tRepo.save(rTemplate);
    }
    
}

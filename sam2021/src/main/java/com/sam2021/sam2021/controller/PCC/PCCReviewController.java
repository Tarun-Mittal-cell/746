package com.sam2021.sam2021.controller.PCC;

import java.util.List;

import com.sam2021.sam2021.models.Paper;
import com.sam2021.sam2021.service.PaperService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PCCReviewController {

    @Autowired
    private PaperService pservice;
    
    @GetMapping(value = "/PCCReview/{id}")
    public String displayReviewDeadlines(Model model, @PathVariable("id") long id){

        List<Paper> papers = pservice.findByTopic(id);
        model.addAttribute("papers", papers);

        return "PCCReview";
    }

}

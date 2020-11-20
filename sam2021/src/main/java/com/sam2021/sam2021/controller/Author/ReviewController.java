package com.sam2021.sam2021.controller.Author;

import java.util.List;

import com.sam2021.sam2021.models.Paper;
import com.sam2021.sam2021.service.PaperService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReviewController {

    @Autowired
    private PaperService pser;

    
    @RequestMapping(value="/PaperReviews/{id}", method = RequestMethod.GET)
    public String displayHomepage(@PathVariable("id") Long id, Model model){
        List<Paper> papers = pser.FindAllPapers(id);
        model.addAttribute("papers", papers);
        return "PaperReviews";
    }
}

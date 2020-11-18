package com.sam2021.sam2021.controller.PCC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AssignPaperPCController {


    @GetMapping(value = "/AssignPaperPCC/{id}")
    public String displayReviewDeadlines(Model model, @PathVariable("id") long id){

        return "AssignPaperPCC";
    }
}

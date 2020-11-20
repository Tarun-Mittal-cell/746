package com.sam2021.sam2021.controller.PCC;

import java.util.List;

import com.sam2021.sam2021.models.Topic;
import com.sam2021.sam2021.service.TopicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReviewDeadlinesController {
    @Autowired
    private TopicService tpservice;

    @RequestMapping(value="/ReviewDeadlinesPCC", method = RequestMethod.GET)
    public String displayReviewDeadlines(Model model){
        List<Topic> topics = tpservice.getTopics();
        model.addAttribute("topics", topics);
        return "ReviewDeadlinesPCC";
    }

}

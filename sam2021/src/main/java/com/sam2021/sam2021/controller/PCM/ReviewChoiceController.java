package com.sam2021.sam2021.controller.PCM;

import java.util.ArrayList;
import java.util.List;

import com.sam2021.sam2021.models.Paper;
import com.sam2021.sam2021.models.Topic;
import com.sam2021.sam2021.models.User;
import com.sam2021.sam2021.service.PaperService;
import com.sam2021.sam2021.service.TopicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReviewChoiceController {
    @Autowired
    private PaperService paperService;

    @Autowired
    private TopicService topicService;

    private List<Topic> topics = new ArrayList<>();

    @RequestMapping(value="/HomepagePCM", method = RequestMethod.GET)
    public String displayHomepage(Model model){
        User user = new User();
        model.addAttribute("user", user);

        topics = topicService.getTopics();
        model.addAttribute("topics", topics);

        return "HomepagePCM";
    }

    @GetMapping(value="/HomepagePCM/popup/{topicId}")
    public void getPapers(@PathVariable("topicId") long topicId, Model model){
        for(Topic t : topics){
            if(t.getId() == topicId){
                model.addAttribute("papers", t.getPapers());
            }
        }
    }

    @GetMapping(value = "/HomepagePCM/pref/{id}/{paperId}")
    public void changePref(@PathVariable("id") long id, @PathVariable("paperId") long paperId, Model model) {
        paperService.toggleInterested(id, paperId);
    }
}
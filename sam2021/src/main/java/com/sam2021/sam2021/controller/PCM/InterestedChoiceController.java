package com.sam2021.sam2021.controller.PCM;

import java.util.ArrayList;
import java.util.List;

import com.sam2021.sam2021.models.Paper;
import com.sam2021.sam2021.models.Topic;
import com.sam2021.sam2021.models.User;
import com.sam2021.sam2021.service.ManageUserService;
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
public class InterestedChoiceController {
    @Autowired
    private PaperService paperService;

    @Autowired
    private TopicService topicService;

    @Autowired
    private ManageUserService userService;

    @RequestMapping(value="/SelectInterested/{userId}/{topicId}", method = RequestMethod.GET)
    public String displayHomepage(@PathVariable("userId") long userId, @PathVariable("topicId") long topicId, Model model){
        User user = userService.findbyId(userId).get();
        model.addAttribute("user", user);

        List<Paper> papers = paperService.getByTopic(topicId);
        model.addAttribute("papers", papers);

        return "SelectInterested";
    }
}
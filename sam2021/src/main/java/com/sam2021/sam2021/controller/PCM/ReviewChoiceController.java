package com.sam2021.sam2021.controller.PCM;

import com.sam2021.sam2021.models.User;
import com.sam2021.sam2021.service.PaperService;
import com.sam2021.sam2021.service.TopicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReviewChoiceController {
    @Autowired
    private PaperService paperService;

    @Autowired
    private TopicService topicService;

    @RequestMapping(value="/HomepagePCM", method = RequestMethod.GET)
    public String displayHomepage(Model model){
        User user = new User();
        model.addAttribute("user", user);

        model.addAttribute("topics", topicService.getTopics());

        return "HomepagePCM";
    }
}

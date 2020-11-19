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
public class ReviewChoiceController {
    @Autowired
    private PaperService paperService;

    @Autowired
    private TopicService topicService;

    @Autowired
    private ManageUserService userService;

    private List<Topic> topics = new ArrayList<>();
    User user;

    @RequestMapping(value="/HomepagePCM/{id}", method = RequestMethod.GET)
    public String displayHomepage(@PathVariable("id") long id, Model model){
        user = userService.findbyId(id).get();
        model.addAttribute("user", user);

        model.addAttribute("userId", id);

        topics = topicService.getTopics();
        model.addAttribute("topics", topics);

        return "HomepagePCM";
    }

    @GetMapping(value = "/HomepagePCM/redirect/{topicId}")
    public String displaySelect(@PathVariable("topicId") long topicId, Model Model){
        return "redirect:/SelectInterested/"+user.getId()+"/"+topicId;
    }
}

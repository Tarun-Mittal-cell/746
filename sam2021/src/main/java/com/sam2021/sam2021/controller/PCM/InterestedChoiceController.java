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

    private User user;
    private List<Paper> papers;
    private List<Paper> ipapers;
    private long topicId;

    @RequestMapping(value="/SelectInterested/{userId}/{topicId}", method = RequestMethod.GET)
    public String displayPage(@PathVariable("userId") long userId, @PathVariable("topicId") long topicId, Model model){
        user = userService.findbyId(userId).get();
        model.addAttribute("user", user);
        this.topicId = topicId;

        papers = paperService.findByTopic(topicId);
        ipapers = new ArrayList<>();

        List<Paper> ownPapers = new ArrayList<>();

        for(Paper p : papers){
            if(p.getContactAuthor() == user){
                ownPapers.add(p);
            }
            else if(p.getReviewers().contains(user)){
                ipapers.add(p);
            }
        }
        papers.removeAll(ipapers);
        papers.removeAll(ownPapers);

        model.addAttribute("papers", papers);
        model.addAttribute("ipapers", ipapers);

        return "SelectInterested";
    }

    @GetMapping(value = "/SelectInterested/toggle/{paperId}")
    public String toggleSelected(@PathVariable("paperId") long paperId, Model Model){
        paperService.toggleInterested(user.getId(), paperId);
        return "redirect:/SelectInterested/"+user.getId()+"/"+topicId;
    }
}
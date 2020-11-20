package com.sam2021.sam2021.controller.PCM;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
public class PCMReviewController {
    @Autowired
    private ManageUserService userService;

    @Autowired
    private PaperService paperService;

    private User user;

    @RequestMapping(value = "/PCMReview/{userId}", method = RequestMethod.GET)
    public String displayHomepage(@PathVariable("userId") long userId, Model model) {
        user = userService.findbyId(userId).get();

        List<Paper> papers = paperService.findByReviewer(userId);

        model.addAttribute("user", user);
        model.addAttribute("papers", papers);

        return "PCMReview";
    }

    @GetMapping(value = "/PCMReview/redirectHome")
    public String redirectReview(Model Model){
        return "redirect:/HomepagePCM/"+user.getId();
    }

    @GetMapping(value = "/PCMReview/select/{paperId}")
    public String redirectReviewPage(@PathVariable("paperId") long paperId, Model model){
        return "redirect:/PCMReview/"+user.getId()+"/review/"+paperId;
    }

    @RequestMapping(value = "/PCMReview/{userId}/review/{paperId}", method = RequestMethod.GET)
    public String displayReviewPage(@PathVariable("userId") long userId, @PathVariable("paperId") long paperId, Model model){
        Paper paper = paperService.findById(paperId);
        String reviewTemplateName = paper.getTopic().getReviewTemp().getFilename();

        model.addAttribute("reviewTemplate", reviewTemplateName);

        return "ReviewContainer";
    }
}
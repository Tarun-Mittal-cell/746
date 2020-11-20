package com.sam2021.sam2021.controller.PCM;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.sam2021.sam2021.models.Paper;
import com.sam2021.sam2021.models.Review;
import com.sam2021.sam2021.models.Topic;
import com.sam2021.sam2021.models.User;
import com.sam2021.sam2021.service.ManageUserService;
import com.sam2021.sam2021.service.PaperService;
import com.sam2021.sam2021.service.ReviewService;
import com.sam2021.sam2021.service.TopicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PCMReviewController {
    @Autowired
    private ManageUserService userService;

    @Autowired
    private PaperService paperService;

    @Autowired
    private ReviewService reviewService;

    private User user;

    @RequestMapping(value = "/PCMReview/{userId}", method = RequestMethod.GET)
    public String displayPage(@PathVariable("userId") long userId, Model model) {
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
        return "redirect:/PCMReview/review/"+paperId;
    }

    @RequestMapping(value = "/PCMReview/review/{paperId}", method = RequestMethod.GET)
    public String displayReviewPage(@PathVariable("paperId") long paperId, Model model){
        Paper paper = paperService.findById(paperId);
        String reviewTemplateName = paper.getTopic().getReviewTemp().getFilename();

        Review review = reviewService.findOwnReview(user.getId(), paperId);
        ReviewContent reviewContent = new ReviewContent();
        if(review.getReview_user() == user){
            reviewContent.setText(review.getPcmReview());
            model.addAttribute("reviewText", reviewContent);
        }

        model.addAttribute("reviewTemplate", reviewTemplateName);
        model.addAttribute("paper", paper);

        return "ReviewContainer";
    }

    @RequestMapping(value = "/PCMReview/SubmitReview/{paperId}", method = RequestMethod.POST)
    public String submitReview(@ModelAttribute("reviewText") ReviewContent reviewContent, @PathVariable("paperId") long paperId){
        Review review = reviewService.findOwnReview(user.getId(), paperId);
        if(review == null){
            review = new Review(reviewContent.getText());
        }
        review.setPaper(paperService.findById(paperId));
        review.setReview_user(userService.findbyId(user.getId()).get());
        reviewService.save(review);

        return "redirect:/PCMReview/"+user.getId();
    }

    public class ReviewContent{
        public List<String> text = new ArrayList<>(100);

        public List<String> getText(){
            return text;
        }

        public void setText(List<String> text){
            this.text = text;
        }
    }
}
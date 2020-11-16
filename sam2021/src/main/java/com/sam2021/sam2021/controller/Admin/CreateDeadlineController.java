package com.sam2021.sam2021.controller.Admin;

import java.util.List;

import javax.validation.Valid;

import com.sam2021.sam2021.models.Deadlines;
import com.sam2021.sam2021.models.ReviewTemplate;
import com.sam2021.sam2021.models.Topic;
import com.sam2021.sam2021.models.User;
import com.sam2021.sam2021.repository.DeadlineRepo;
import com.sam2021.sam2021.repository.TopicRepo;
import com.sam2021.sam2021.service.CreateDeadlineService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
public class CreateDeadlineController {
    @Autowired
    private CreateDeadlineService cDeadlineService;

    @Autowired
    private TopicRepo deadrepo;

    @RequestMapping(value = "/CreateDeadline", method = RequestMethod.GET)
    public String displaycreatedeadline(Model model) {

        User user = new User();
        model.addAttribute("chair", user);

        ReviewTemplate reviewtemp = new ReviewTemplate();
        model.addAttribute("reviewtemp", reviewtemp);

        Deadlines deadlines = new Deadlines();
        model.addAttribute("Deadlines", deadlines);

        List<User> chairmans = cDeadlineService.getallchairman();
        List<ReviewTemplate> reviewTemplates = cDeadlineService.getAllReviewTemplates();

        model.addAttribute("chairmans", chairmans);
        model.addAttribute("ReviewTemps", reviewTemplates);
        return "CreateDeadline";
    }

    @RequestMapping(value="/CreateDeadline", method=RequestMethod.POST)
    public String creatDeadline( @ModelAttribute("title") String name, @ModelAttribute("Description") String description, @Valid @ModelAttribute("Deadlines") Deadlines deadlines ,BindingResult result ,@ModelAttribute("chair") User chairman ,@ModelAttribute("reviewtemp") ReviewTemplate reviewTemplate, RedirectAttributes attributes) {
        if(result.hasErrors()){
           return "CreateDeadline";
        }
        Topic topic = new Topic();
        topic.setDescription(description);
        topic.setName(name);
        topic.setChairman(chairman);
        topic.setReviewTemp(reviewTemplate);
        topic.setDeadlines(deadlines);
        deadlines.setTopic(topic);
        deadrepo.save(topic);
        attributes.addFlashAttribute("message", "Successfully created " + topic.getName());
        return "redirect:/CreateDeadline";
    }
    
}

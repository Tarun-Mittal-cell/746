package com.sam2021.sam2021.controller.PCC;

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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReviewDeadlinesController {
    @Autowired
    private TopicService tpservice;

    @Autowired
    private PaperService pservice;

    @RequestMapping(value="/ReviewDeadlinesPCC", method = RequestMethod.GET)
    public String displayReviewDeadlines(Model model){
        List<Topic> topics = tpservice.getTopics();
        model.addAttribute("topics", topics);
        return "ReviewDeadlinesPCC";
    }

    @GetMapping(value = "/AssignPaperPCC/{id}")
    public String displayReviewDeadlines(Model model, @PathVariable("id") long id){

        List<Paper> papers = pservice.findbytopicFalse(id);
        model.addAttribute("papers", papers);
        model.addAttribute("userlist", new memberwrapper(new ArrayList<User>()));
        

        return "AssignPaperPCC";
    }

    @RequestMapping(value = "/AssignPaperPCC/{topicid}/assign/{paperid}", method = RequestMethod.GET)
    public String AssignPCM( @PathVariable("topicid") long topicid, @PathVariable("paperid") long paperid, @ModelAttribute memberwrapper memberWrapper, Model model){
        List<User> users = memberWrapper.getUserlist();
        pservice.removnoneassigned(paperid, users);

        return "redirect:/AssignPaperPCC/" + topicid;
    }
    
    public class memberwrapper {
        private List<User> userlist;
    
        public List<User> getUserlist() {
            return userlist;
        }
    
        public void setUserlist(List<User> userlist) {
            this.userlist = userlist;
        }
    
        public memberwrapper(List<User> userlist) {
            this.userlist = userlist;
        }
    
        public memberwrapper() {
        }
            
            
    }

}

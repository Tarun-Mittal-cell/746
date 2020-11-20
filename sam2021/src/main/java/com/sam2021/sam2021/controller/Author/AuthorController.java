package com.sam2021.sam2021.controller.Author;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import com.sam2021.sam2021.models.Paper;
import com.sam2021.sam2021.models.Topic;
import com.sam2021.sam2021.models.User;
import com.sam2021.sam2021.service.ManageUserService;
import com.sam2021.sam2021.service.PaperService;
import com.sam2021.sam2021.service.TopicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class AuthorController {

    @Autowired
    private TopicService tser;

    @Autowired
    private PaperService pser;

    @Autowired
    private ManageUserService manageruserser;

    private long memberid;

    @Autowired
	private ServletContext context;

    @RequestMapping(value="/AuthorResearchPaperDeadlines/{id}", method = RequestMethod.GET)
    public String displayHomepage(@PathVariable("id") Long id, Model model){
        memberid = id;
        List<Topic> topics = tser.getTopics();
        model.addAttribute("topics", topics);
        Topic topic = new Topic();
        Paper paper = new Paper();
        model.addAttribute("topicchoice", topic);
        model.addAttribute("paper",paper );
        return "AuthorResearchPaperDeadlines";
    }

    @GetMapping(value="/AuthorResearchPaperDeadlines")
    public String submitPaper(@RequestParam("file") MultipartFile file, @ModelAttribute("topicchoice") Topic topic, @Valid @ModelAttribute Paper paper, BindingResult result){

        User user = manageruserser.findbyId(memberid).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + memberid));
        paper.setTopic(topic);
        String filename = file.getOriginalFilename();
        System.out.print(filename);
        if(paper.getRevision().equals("True")){
            try{
                Paper curpaper = pser.findByFilename(filename);
                paper.setId(curpaper.getId());
                paper.setFilename(filename);
                paper.setContactAuthor(user);
                paper.setTopic(topic);
                pser.save(paper);
                File destinationFile = new File(context.getRealPath("/WEB-INF/PaperSubmissions")+  File.separator + file.getOriginalFilename());
                file.transferTo(destinationFile);
                
            }catch (IOException e) {
                e.printStackTrace();
            }
        }else if(paper.getRevision().equals("False")){
            try{
                 paper.setFilename(filename);
                paper.setContactAuthor(user);
                pser.save(paper);
                File destinationFile = new File(context.getRealPath("/WEB-INF/PaperSubmissions")+  File.separator + file.getOriginalFilename());
                file.transferTo(destinationFile);
            }catch (IOException e) {
                e.printStackTrace();
            }
           
        }
        
        return "AuthorResearchPaperDeadlines";
    }
    
}

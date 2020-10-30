package com.sam2021.sam2021.controller.Author;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthorController {
    @RequestMapping(value="/AuthorResearchPaperDeadlines", method = RequestMethod.GET)
    public String displayHomepage(){
        return "AuthorResearchPaperDeadlines";
    }
}

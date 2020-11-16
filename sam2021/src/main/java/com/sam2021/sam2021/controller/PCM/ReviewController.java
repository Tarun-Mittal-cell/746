package com.sam2021.sam2021.controller.PCM;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReviewController {
    @RequestMapping(value="/HomepagePCM", method = RequestMethod.GET)
    public String displayHomepage(){
        return "HomepagePCM";
    }
}
package com.sam2021.sam2021.controller.PCC;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ChairmanController {
    @RequestMapping(value="/ReviewDeadlinesPCC", method = RequestMethod.GET)
    public String displayReviewDeadlines(){
        return "ReviewDeadlinesPCC";
    }
}

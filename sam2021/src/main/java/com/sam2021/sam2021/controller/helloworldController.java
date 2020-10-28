package com.sam2021.sam2021.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class helloworldController {
    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello(){
        return "YEET";
    }
}

package com.sam2021.sam2021.controller;

import com.sam2021.sam2021.models.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegistrationController {
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String displayregister(User user){
        return "registration";
    }
}

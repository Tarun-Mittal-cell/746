package com.sam2021.sam2021.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.sam2021.sam2021.models.User;
import com.sam2021.sam2021.validation.PasswordValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class RegistrationController {

    @Autowired
    private PasswordValidator pwvalid;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String displayregister(Model model){
        User user = new User();
        model.addAttribute("user", user);
        List<String> accountType = new ArrayList<String>(){{
            add("Chairman");
            add("Memeber");
            add("Author");
              }};
        model.addAttribute("accountTypes", accountType);
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String userRegistration(final @Valid User user, BindingResult result){

        pwvalid.validate(user, result);
        if(result.hasErrors()){
            return "registration";
        }
        return "registration";
    }
    



}

package com.sam2021.sam2021.controller;



import javax.validation.Valid;

import com.sam2021.sam2021.models.User;
import com.sam2021.sam2021.service.RegistrationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class RegistrationController {

    @Autowired
    private RegistrationService regservice;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String displayregister(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String userRegistration(final @ModelAttribute("user") @Valid User user, BindingResult result){
        System.out.print(user.getFtname()+"\n");
        System.out.print(user.getLtname()+"\n");
        System.out.print(user.getEmail()+"\n");
        System.out.print(user.getPassword()+"\n");
        System.out.print(user.getPhonenumber()+"\n");
        System.out.print(user.getAccountType()+"\n");
        User existing = regservice.findByEmail(user.getEmail());
        if (existing != null) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        }

        if(result.hasErrors()){
            return "registration";
        }
        
        regservice.save(user);
        return "login";
    }
    



}

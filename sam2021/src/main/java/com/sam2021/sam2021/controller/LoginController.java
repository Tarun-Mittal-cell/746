package com.sam2021.sam2021.controller;

import com.sam2021.sam2021.models.AccountTypeEnum;
import com.sam2021.sam2021.service.LoginService;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LoginController {

    @Autowired
    private LoginService loginSer;

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String displayLogin(Model model, String error){

        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        return "login";
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String login(@RequestParam(value = "email", required = true)String email,@RequestParam(value = "password", required = true)String password, Model model){
        password = DigestUtils.md5Hex(password);
        if(loginSer.validateUser(email, password)){
            model.addAttribute("email", email);
            model.addAttribute("password", password);
            String accotype = loginSer.getAccountType(email);
            System.out.print(accotype);
            if(accotype.equals(AccountTypeEnum.Chairman.toString())){
                return "redirect:/ReviewDeadlinesPCC";
            }
            else if(accotype.equals(AccountTypeEnum.Member)){
                return "HomepagePCM";
            }
            else if(accotype.equals(AccountTypeEnum.Author)){
                return "AuthorResearchPaperDeadlines";
            }
            else if(accotype.equals("Admin")){
                return "ManageUsersAdmin";
            }
        }
        else{
            return "login";
        }
        return null;
        
    }
}

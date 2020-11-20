package com.sam2021.sam2021.controller;

import com.sam2021.sam2021.models.Enums.AccountTypeEnum;
import com.sam2021.sam2021.service.LoginService;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
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
    public String login(@RequestParam(value = "email", required = true)String email,@RequestParam(value = "password", required = true)String password, RedirectAttributes attributes){
        password = DigestUtils.md5Hex(password);
        if(loginSer.validateUser(email, password)){
            // attributes.addAttribute("email", email);
            // attributes.addAttribute("password", password);
            String accotype = loginSer.getAccountType(email);
            Long id = loginSer.getid(email);
            System.out.print(accotype);
            if(accotype.equals(AccountTypeEnum.Chairman.toString())) {
                return "redirect:/ReviewDeadlinesPCC";
            }
            else if(accotype.equals(AccountTypeEnum.Member.toString())){
                return "redirect:/HomepagePCM";
            }
            else if(accotype.equals(AccountTypeEnum.Author.toString())){
                return "redirect:/AuthorResearchPaperDeadlines/" + id ;
            }
            else if(accotype.equals("Admin")){
                return "redirect:/ManageUsersAdmin";
            }
        }
        else{
            return "login";
        }
        return "login";
        
    }
}

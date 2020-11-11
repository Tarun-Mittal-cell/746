package com.sam2021.sam2021.controller.Admin;

import com.sam2021.sam2021.models.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ManageUsersController {
    @RequestMapping(value="/ManageUsersAdmin", method = RequestMethod.GET)
    public String displayUserManagePage(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "ManageUsersAdmin";
    }
}

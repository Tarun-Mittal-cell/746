package com.sam2021.sam2021.controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ManageUsersController {
    @RequestMapping(value="/ManageUsersAdmin", method = RequestMethod.GET)
    public String displayUserManagePage(){
        return "ManageUsersAdmin";
    }
}

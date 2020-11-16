package com.sam2021.sam2021.controller.Admin;

import java.util.List;

import javax.validation.Valid;

import com.sam2021.sam2021.models.User;

import com.sam2021.sam2021.service.ManageUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




@Controller
public class ManageUsersController {

    @Autowired
    private ManageUserService manageruserser;

    /**
     * Loads Manage User page with all the users 
     * @param model
     * @return 
     */
    @RequestMapping(value = "/ManageUsersAdmin", method = RequestMethod.GET)
    public String displayUserManagePage(Model model) {

        User user = new User();
        model.addAttribute("user", user);

        model.addAttribute("users", manageruserser.getAllUsers());
        return "ManageUsersAdmin";
    }

    /**
     * Deletes user based off of primary key in the Mysql database
     * @param id
     * @param model
     * @return
     */
    @GetMapping(value = "/ManageUsersAdmin/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {

        User user = manageruserser.findbyId(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        manageruserser.delete(user);
        return "redirect:/ManageUsersAdmin";
    }

    /**
     * Creates edit page and fills the forms with the current data from mysql based off of id
     * @param model
     * @param id
     * @return
     */
    @GetMapping(value = { "/ManageUsersAdmin/edit/{id}" })
    public String showEditUser(Model model, @PathVariable("id") Long id) {
        User user = manageruserser.findbyId(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("user", user);
        if(user == null){
            model.addAttribute("errorMessage", "User not found");
            return "redirect:/ManageUsersAdmin";
        }
        return "user_edit";   
    }

    /**
     * Does a Post to update the current id row in the mysql database
     * @param model
     * @param id
     * @param user
     * @param result
     * @return
     */
    @PostMapping(value = {"/ManageUsersAdmin/update/{id}"})
    public String updateContact(Model model, @PathVariable("id") Long id, @ModelAttribute("user") User user, BindingResult result) {
        if(result.hasErrors()){
            model.addAttribute("errorMessage", result.getFieldError());
            return "user_edit";
        }
        user.setId(id);
        manageruserser.update(user);
        return "redirect:/ManageUsersAdmin";

    }

    @RequestMapping(value={"/ManageUsersAdmin/create"}, method=RequestMethod.POST)
    public String requestMethodName(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
        System.out.print(user.getEmail());
        if(result.hasErrors()){
            model.addAttribute("errorMessage", "Please re enter information");
            return "ManageUsersAdmin";
        }
        manageruserser.save(user);
        return "redirect:/ManageUsersAdmin";
    }
    
}

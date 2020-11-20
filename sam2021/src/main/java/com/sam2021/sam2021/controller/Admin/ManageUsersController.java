package com.sam2021.sam2021.controller.Admin;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.sam2021.sam2021.models.Topic;
import com.sam2021.sam2021.models.User;
import com.sam2021.sam2021.models.Enums.AccountTypeEnum;
import com.sam2021.sam2021.repository.TopicRepo;
import com.sam2021.sam2021.service.TopicService;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;




@Controller
public class ManageUsersController {

    @Autowired
    private ManageUserService manageruserser;

    @Autowired
    private TopicService ctservice;

    /**
     * Loads Manage User page with all the users 
     * @param model
     * @return 
     */
    @RequestMapping(value = "/ManageUsersAdmin", method = RequestMethod.GET)
    public String displayUserManagePage(Model model) {

        User user = new User();
        model.addAttribute("user", user);

        List<User> users = manageruserser.getChairandMeb();

        model.addAttribute("users", users );
        return "ManageUsersAdmin";
    }

    /**
     * Deletes user based off of primary key in the Mysql database
     * @param id
     * @param model
     * @return
     */
    @GetMapping(value = "/ManageUsersAdmin/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model, RedirectAttributes attributes) {

        User user = manageruserser.findbyId(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        String message = manageruserser.delete(user);
        if(message.equals("Chairman is current active with one of more Topics")){
           attributes.addFlashAttribute("Message", message);
        }
        attributes.addFlashAttribute("Message", message);
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

    @RequestMapping(value={"/ManageUsersAdmin"}, method=RequestMethod.POST)
    public String createUSer(RedirectAttributes attributes, @Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
        
        if(result.hasErrors()){
            model.addAttribute("Message", "Please re enter information");
            return "ManageUsersAdmin";
        }
        User existing = manageruserser.findByEmail(user.getEmail());
        if (existing != null) {
            model.addAttribute("Message", "Email already has an account: " + existing.getEmail());
            return "ManageUsersAdmin";
        }
        manageruserser.save(user);
        attributes.addFlashAttribute("Message", "Successfully created User account: " + user.getEmail());
        return "redirect:/ManageUsersAdmin";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logout(){
        return "login";
    }
    
}

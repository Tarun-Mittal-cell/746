package com.sam2021.sam2021.controller.Author;
import java.util.List;
import com.sam2021.sam2021.models.ManageNotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class ManageNotifications {
    @Autowired
    private ManageNotification cManageNotifications;
    /**
     * Get Notification on the basis of role
     * @param model
     * @return
     */
    @RequestMapping(value = "/ManageNotification/get", method = RequestMethod.GET)
    public String getResearchPaper(Model model) {
        ManageNotification manageNotification = new ManageNotification();
        model.addAttribute("ManageNotification", manageNotification);
        model.addAttribute("ManageNotification", manageNotification.findbyId(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id)););
        return "Manage Notification";
    }
}


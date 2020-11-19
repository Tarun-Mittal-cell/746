package com.sam2021.sam2021.controller.Author;
import java.util.List;
import com.sam2021.sam2021.models.ManageReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class ManageReview {
    @Autowired
    private ManageReview ManageReview;
    /**
     * Get Review on the basis of role Id of User and reviewer
     * @param model
     * @return
     */
    @RequestMapping(value = "/ManageReview/get", method = RequestMethod.GET)
    public String getReview(Model model) {
        ManageReview manageReview = new ManageReview();
        model.addAttribute("ManageReview", manageReview.findbyId(userId).findbyId(reviewerId).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + userId + " and Reviewer Id :" + reviewerId)););
        return "Manage Review";
    }
}


package com.sam2021.sam2021.controller.Author;
import java.util.List;
import com.sam2021.sam2021.models.ResearchPaper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class UploadResearch {
    @Autowired
    private ManageResearchPaper cGetResearchPaper;
    @Autowired
    private ManageResearchPaper manageResearchPaper;
    /**
     * Loads Research Paper on the basis of Id
     * @param model
     * @return
     */
    @RequestMapping(value = "/ResearchPaper/get", method = RequestMethod.GET)
    public String getResearchPaper(Model model) {
        ResearchPaper researchPaper = new ResearchPaper();
        model.addAttribute("researchPaper", researchPaper);
        model.addAttribute("users", manageResearchPaper.findbyId(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id)););
        return "Research Paper";
    }
    /**
     * Upload reserch paper
     * @param model
     * @return
     */
    @RequestMapping(value = {"/ResearchPaper/create"}, method = RequestMethod.POST)
    public String UploadReseachPaper(@Valid @ModelAttribute("researchPaper") ResearchPaper researchPaper, BindingResult result, Model model) {
        manageruserser.save(researchPaper);
        return "redirect:/ManageResearchPaper";
    }
}
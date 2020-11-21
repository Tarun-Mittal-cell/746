package com.sam2021.sam2021.controller.Admin;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import com.sam2021.sam2021.service.ReviewTemplateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CreateReviewController {
    @Autowired
    private ReviewTemplateService revservice;

    @Autowired
	ServletContext context;


    @RequestMapping(value="/CreateReview", method = RequestMethod.GET)
    public String displayCreateReviewPage(){
        return "CreateReview";
    }

    @RequestMapping(value = "/CreateReview", method = RequestMethod.POST)
    public String uploadTemplate(@RequestParam("file") MultipartFile file, RedirectAttributes attributes){
        if (file.isEmpty()) {
            attributes.addFlashAttribute("message", "Please select a file to upload.");
            return "redirect:/CreateReview";
        }
        try{
            revservice.save(file.getOriginalFilename());
            File destinationFile = new File(context.getRealPath("/WEB-INF/templates/reviewTemplates")+  File.separator + file.getOriginalFilename());
            file.transferTo(destinationFile);
        }catch (IOException e) {
            e.printStackTrace();
        }
        
        
        attributes.addFlashAttribute("message", "You successfully uploaded " + file.getOriginalFilename() + '!');
        
        
        return "redirect:/CreateReview";
    }
}

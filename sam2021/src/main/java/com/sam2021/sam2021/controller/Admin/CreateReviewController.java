package com.sam2021.sam2021.controller.Admin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.http.HttpServletRequest;

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
            String dir = "/ReviewTemplates/";
            Files.copy(file.getInputStream(), Paths.get(dir+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
        }catch (IOException e) {
            e.printStackTrace();
        }
        
        
        attributes.addFlashAttribute("message", "You successfully uploaded " + file + '!');
        
        
        return "redirect:/CreateReview";
    }
}

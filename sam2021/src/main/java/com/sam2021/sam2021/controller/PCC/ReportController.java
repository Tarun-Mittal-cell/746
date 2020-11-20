package com.sam2021.sam2021.controller.PCC;

import com.sam2021.sam2021.models.Paper;
import com.sam2021.sam2021.models.Report;
import com.sam2021.sam2021.service.PaperService;
import com.sam2021.sam2021.service.ReportService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReportController {

    @Autowired
    private ReportService rser;

    @Autowired
    private PaperService pser;

    @GetMapping(value = "/generatereport/{id}")
    public String displayReviewDeadlines(Model model, @PathVariable("id") long id){

        Report report = new Report();
        Paper paper = pser.findById(id);
        report.setPaper(paper);
        model.addAttribute("Report", report);
        return "generatereport";
    }

    @RequestMapping(value = "/AssignPaperPCC/{topicid}/assign/{paperid}", method = RequestMethod.GET)
    public String generatereport(Model model, @ModelAttribute Report report, @PathVariable("id") long id){
        rser.save(report);
        return "redirect:/PCCReview/" + report.getPaper().getId();
    }
}

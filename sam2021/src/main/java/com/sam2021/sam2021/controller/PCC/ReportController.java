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

    private long paperid;

    @GetMapping(value = "/generatereport/{id}")
    public String displayReviewDeadlines(Model model, @PathVariable("id") long id){
        paperid = id;
        Report report = new Report();
        
        model.addAttribute("report", report);
        return "generatereport";
    }

    @RequestMapping(value = "/generatereport", method = RequestMethod.POST)
    public String generatereport(Model model, @ModelAttribute Report report){
        Paper paper = pser.findById(paperid);
        report.setPaper(paper);
        System.out.print(report.getRating());
        System.out.print(report.getReview());
        rser.save(report);
        return "redirect:/PCCReview/" + paper.getTopic().getId();
    }
}

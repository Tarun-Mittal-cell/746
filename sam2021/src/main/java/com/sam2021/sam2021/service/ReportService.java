package com.sam2021.sam2021.service;

import com.sam2021.sam2021.models.Report;
import com.sam2021.sam2021.repository.ReportRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {
    
    @Autowired
    private ReportRepo reportRepo;

    public Report save(Report report){
        return reportRepo.save(report);
    }
}

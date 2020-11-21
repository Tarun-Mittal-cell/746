package com.sam2021.sam2021.repository;

import com.sam2021.sam2021.models.Report;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepo extends JpaRepository<Report, Long> {
    
}

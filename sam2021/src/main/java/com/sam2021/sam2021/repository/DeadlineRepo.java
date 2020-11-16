package com.sam2021.sam2021.repository;

import com.sam2021.sam2021.models.Deadlines;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface DeadlineRepo extends JpaRepository<Deadlines, String> {
    
}

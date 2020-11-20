package com.sam2021.sam2021.repository;

import com.sam2021.sam2021.models.Review;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepo extends JpaRepository<Review, Long> {
    
}

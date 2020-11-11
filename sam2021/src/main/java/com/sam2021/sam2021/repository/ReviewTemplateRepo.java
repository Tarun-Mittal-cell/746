package com.sam2021.sam2021.repository;

import com.sam2021.sam2021.models.ReviewTemplate;


import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewTemplateRepo extends JpaRepository<ReviewTemplate,String>{
    ReviewTemplate findByFilename(String filename);

}
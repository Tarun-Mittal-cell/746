package com.sam2021.sam2021.repository;

import com.sam2021.sam2021.models.ReviewTemplate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ReviewTemplateRepo extends JpaRepository<ReviewTemplate,Long>{
    ReviewTemplate findByFilename(String filename);

}
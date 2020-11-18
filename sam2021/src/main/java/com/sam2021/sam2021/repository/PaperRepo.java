package com.sam2021.sam2021.repository;

import java.util.Optional;

import com.sam2021.sam2021.models.Paper;
import com.sam2021.sam2021.models.Topic;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PaperRepo extends JpaRepository<Paper, Long> {
    Optional<Paper> findById(Long id);

}

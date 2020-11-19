package com.sam2021.sam2021.repository;

import java.util.List;
import java.util.Optional;

import com.sam2021.sam2021.models.Paper;
import com.sam2021.sam2021.models.Topic;
import com.sam2021.sam2021.models.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PaperRepo extends JpaRepository<Paper, Long> {
    Optional<Paper> findById(Long id);

    @Query("SELECT a, b FROM Paper a JOIN a.topic b WHERE a.assigned = 'F' and b.id = ?1")
    List<Paper> findByTopic(Long id);

    

}
package com.sam2021.sam2021.repository;

import java.util.List;
import java.util.Optional;

import com.sam2021.sam2021.models.Paper;
import com.sam2021.sam2021.models.Topic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PaperRepo extends JpaRepository<Paper, Long> {
    Optional<Paper> findById(Long id);

    @Query("FROM Paper JOIN Topic on Paper.topic_id = Topic.id where assigned = 'F'")
    List<Paper> findByTopic();
}

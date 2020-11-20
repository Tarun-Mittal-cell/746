package com.sam2021.sam2021.repository;

import java.util.List;
import java.util.Optional;

import com.sam2021.sam2021.models.Paper;
import com.sam2021.sam2021.models.Topic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

public interface PaperRepo extends JpaRepository<Paper, Long> {

    @Query("FROM Paper WHERE id=?1")
    Paper getById(long id);

    @Query("FROM Paper WHERE topic_id=?1")
    List<Paper> findByTopic(long id);

    @Query("from Paper p join p.users u where u.id = ?1")
    List<Paper> FindAllPapers(Long id);
}
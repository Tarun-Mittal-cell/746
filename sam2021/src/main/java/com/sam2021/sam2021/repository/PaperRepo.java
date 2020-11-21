package com.sam2021.sam2021.repository;

import java.util.List;
import java.util.Optional;

import com.sam2021.sam2021.models.Paper;
import com.sam2021.sam2021.models.Topic;
import com.sam2021.sam2021.models.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PaperRepo extends JpaRepository<Paper, Long> {
    @Query("FROM Paper WHERE id=?1")
    Paper findById(long id); 

    @Query("FROM Paper WHERE id=?1")
    Paper findByIdd(long id); 

    @Query("SELECT a, b FROM Paper a JOIN a.topic b WHERE a.assigned = 'F' and b.id = ?1")
    List<Paper> findByTopic(Long id);

    @Query("FROM Paper WHERE topic_id=?1")
    List<Paper> findAllByTopic(long id);

    @Query("FROM Paper WHERE filename = ?1")
    Paper findByFilename(String filename);

    @Query("from Paper p join p.contactAuthor u where u.id = ?1")
    public List<Paper> FindAllPapers(Long id);



}
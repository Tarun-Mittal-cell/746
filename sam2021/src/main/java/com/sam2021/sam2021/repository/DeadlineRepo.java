package com.sam2021.sam2021.repository;

import java.util.List;
import java.util.Optional;

import com.sam2021.sam2021.models.Deadlines;
import com.sam2021.sam2021.models.Topic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


public interface DeadlineRepo extends JpaRepository<Deadlines, String> {

    Optional<Deadlines> findByTopic(Topic topic);

    Optional<Deadlines> findById(Long id);
    
}

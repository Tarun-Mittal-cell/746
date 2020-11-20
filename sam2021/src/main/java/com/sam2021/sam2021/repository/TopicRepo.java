package com.sam2021.sam2021.repository;

import java.util.List;
import java.util.Optional;

import com.sam2021.sam2021.models.Topic;
import com.sam2021.sam2021.models.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

public interface TopicRepo extends JpaRepository<Topic, Long> {

    @Query("FROM Topic")
    List<Topic> getAll();
    
    List<Topic> findByChairman(User chairman);
    Optional<Topic> findById(Long id);
}

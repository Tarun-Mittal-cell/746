package com.sam2021.sam2021.repository;

import java.util.List;
import java.util.Optional;

import com.sam2021.sam2021.models.Topic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface TopicRepo extends JpaRepository<Topic, Long> {


}

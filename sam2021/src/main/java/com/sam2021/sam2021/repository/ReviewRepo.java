package com.sam2021.sam2021.repository;

import com.sam2021.sam2021.models.Review;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReviewRepo extends JpaRepository<Review, Long> {
    @Query("FROM Review WHERE review_id=?1 AND paper_id=?2")
    Review findOwnReview(long userId, long paperId);
}

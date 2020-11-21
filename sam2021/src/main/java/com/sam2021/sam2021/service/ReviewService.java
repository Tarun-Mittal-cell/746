package com.sam2021.sam2021.service;

import com.sam2021.sam2021.models.Review;
import com.sam2021.sam2021.repository.ReviewRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepo reviewRepo;

    public Review save(Review review){
        return reviewRepo.save(review);
    }

    public Review findOwnReview(long userId, long paperId){
        return reviewRepo.findOwnReview(userId, paperId);
    }
}

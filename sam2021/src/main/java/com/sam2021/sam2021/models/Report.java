package com.sam2021.sam2021.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Report")
public class Report {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @NotNull
    private String review;

    @NotEmpty
    @NotNull
    private int rating;

    public Report(String review, int rating) {
        this.review = review;
        this.rating = rating;
    }

    //Getter
    public Long getId() {
        return id;
    }

    public int getRating() {
        return rating;
    }

    public String getReview() {
        return review;
    }

    //Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setReview(String review) {
        this.review = review;
    }

    
}

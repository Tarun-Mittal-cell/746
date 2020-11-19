package com.sam2021.sam2021.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull
    private String pcmReview;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "review_id", nullable = false)
    private User review_user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Paper paper;

    public Review() {
    }

    public Review(String pcmReview) {
        this.pcmReview = pcmReview;
    }

    //Getter
    public Long getId() {
        return id;
    }

    public Paper getPaper() {
        return paper;
    }

    public String getPcmReview() {
        return pcmReview;
    }
    public User getReview_user() {
        return review_user;
    }

    //Setter
    public void setId(Long id) {
        this.id = id;
    }
    public void setPaper(Paper paper) {
        this.paper = paper;
    }
    public void setPcmReview(String pcmReview) {
        this.pcmReview = pcmReview;
    }
    public void setReview_user(User review_user) {
        this.review_user = review_user;
    }

}

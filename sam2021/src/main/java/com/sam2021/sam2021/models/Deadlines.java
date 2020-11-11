package com.sam2021.sam2021.models;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Deadlines")
public class Deadlines {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
    @NotEmpty
	private Timestamp paperSubmissionDeadline;
	
	@NotNull
    @NotEmpty
	private Timestamp reviewChoiceDeadline;
	
	@NotNull
    @NotEmpty
	private Timestamp reviewDeadline;

	@NotNull
    @NotEmpty
    private Timestamp AuthorNotifyDeadline;
    
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL )
    @JoinColumn(name = "paper_id", nullable = false)
	private Topic topic;

    public Deadlines(Timestamp paperSubmissionDeadline,Timestamp reviewChoiceDeadline, Timestamp reviewDeadline, Timestamp authorNotifyDeadline, Topic topic) {
        this.paperSubmissionDeadline = paperSubmissionDeadline;
        this.reviewChoiceDeadline = reviewChoiceDeadline;
        this.reviewDeadline = reviewDeadline;
        AuthorNotifyDeadline = authorNotifyDeadline;
        this.topic = topic;
    }

    //Getters
    public Timestamp getAuthorNotifyDeadline() {
        return AuthorNotifyDeadline;
    }

    public Long getId() {
        return id;
    }

    public Timestamp getPaperSubmissionDeadline() {
        return paperSubmissionDeadline;
    }

    public Timestamp getReviewChoiceDeadline() {
        return reviewChoiceDeadline;
    }

    public Timestamp getReviewDeadline() {
        return reviewDeadline;
    }
    
    public Topic getTopic() {
        return topic;
    }

    //Setters
    public void setAuthorNotifyDeadline(Timestamp authorNotifyDeadline) {
        AuthorNotifyDeadline = authorNotifyDeadline;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public void setPaperSubmissionDeadline(Timestamp paperSubmissionDeadline) {
        this.paperSubmissionDeadline = paperSubmissionDeadline;
    }

    public void setReviewChoiceDeadline(Timestamp reviewChoiceDeadline) {
        this.reviewChoiceDeadline = reviewChoiceDeadline;
    }

    public void setReviewDeadline(Timestamp reviewDeadline) {
        this.reviewDeadline = reviewDeadline;
    }
    
    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}

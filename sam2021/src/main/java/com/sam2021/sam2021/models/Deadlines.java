package com.sam2021.sam2021.models;

import java.sql.Date;


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
	
	@NotNull(message = "Parameter Date Adjusted can not be blank or null")
	private Date paperSubmissionDeadline;
	
	@NotNull(message = "Parameter Date Adjusted can not be blank or null")
	private Date reviewChoiceDeadline;
	
	@NotNull(message = "Parameter Date Adjusted can not be blank or null")
	private Date reviewDeadline;

	@NotNull(message = "Parameter Date Adjusted can not be blank or null")
    private Date AuthorNotifyDeadline;
    
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL )
    @JoinColumn(name = "topic_id", nullable = false)
	private Topic topic;

    public Deadlines() {
    }
    

    public Deadlines(Date paperSubmissionDeadline,Date reviewChoiceDeadline, Date reviewDeadline, Date authorNotifyDeadline) {
        this.paperSubmissionDeadline = paperSubmissionDeadline;
        this.reviewChoiceDeadline = reviewChoiceDeadline;
        this.reviewDeadline = reviewDeadline;
        this.AuthorNotifyDeadline = authorNotifyDeadline;
    }

    //Getters
    public Date getAuthorNotifyDeadline() {
        return AuthorNotifyDeadline;
    }

    public Long getId() {
        return id;
    }

    public Date getPaperSubmissionDeadline() {
        return paperSubmissionDeadline;
    }

    public Date getReviewChoiceDeadline() {
        return reviewChoiceDeadline;
    }

    public Date getReviewDeadline() {
        return reviewDeadline;
    }
    
    public Topic getTopic() {
        return topic;
    }

    //Setters
    public void setAuthorNotifyDeadline(Date authorNotifyDeadline) {
        AuthorNotifyDeadline = authorNotifyDeadline;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public void setPaperSubmissionDeadline(Date paperSubmissionDeadline) {
        this.paperSubmissionDeadline = paperSubmissionDeadline;
    }

    public void setReviewChoiceDeadline(Date reviewChoiceDeadline) {
        this.reviewChoiceDeadline = reviewChoiceDeadline;
    }

    public void setReviewDeadline(Date reviewDeadline) {
        this.reviewDeadline = reviewDeadline;
    }
    
    public void setTopic(Topic topic) {
        this.topic = topic;
    }

   
}

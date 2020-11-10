package com.sam2021.sam2021.models;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Paper")
public class Paper {
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
    @NotEmpty
	private String title;
	
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL )
    @JoinColumn(name = "author_id", nullable = false)
    private User contactAuthor;
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "authors", nullable = false)
	private Set<String> authors;
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "reviewer_ids", nullable = false)
    private Set<User> reviewers;
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "review_ids", nullable = false)
    private Set<Review> reviews;
	
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL )
    @JoinColumn(name = "report_id", nullable = false)
    private Report report;
	
	@NotNull
    @NotEmpty
    private Timestamp review_deadline;
	
	@NotNull
    @NotEmpty
	private int revision;
	
	@NotNull
    @NotEmpty
	private String format;
	
	public Paper() {
		
	}
	
	public Paper(String title, User contactAuthor, Set<String> authors, Timestamp review_deadline, int revision, String format) {
		this.title = title;
		this.contactAuthor = contactAuthor;
		this.authors = authors;
		this.review_deadline = review_deadline;
		this.revision = revision;
		this.format = format;
	}

	
	//getters and setters
	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public User getContactAuthor() {
		return contactAuthor;
	}

	public void setContactAuthor(User contactAuthor) {
		this.contactAuthor = contactAuthor;
	}

	public Set<String> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<String> authors) {
		this.authors = authors;
	}

	public Set<User> getReviewers() {
		return reviewers;
	}

	public void setReviewers(Set<User> reviewers) {
		this.reviewers = reviewers;
	}

	public Set<Review> getReviews() {
		return reviews;
	}

	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}

	public Report getReport() {
		return report;
	}

	public void setReport(Report report) {
		this.report = report;
	}

	public Timestamp getReview_deadline() {
		return review_deadline;
	}

	public void setReview_deadline(Timestamp review_deadline) {
		this.review_deadline = review_deadline;
	}

	public int getRevision() {
		return revision;
	}

	public void setRevision(int revision) {
		this.revision = revision;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}
	
}

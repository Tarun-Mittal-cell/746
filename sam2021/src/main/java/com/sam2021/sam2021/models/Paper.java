package com.sam2021.sam2021.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "contactAuth_id", nullable = false)
	private User contactAuthor;
	
	@NotNull
    @NotEmpty
	private String contauthname;

	@NotNull
    @NotEmpty
	private String contauthemail;
	
	@NotNull
    @NotEmpty
	private String authors;
	
	@OneToMany(mappedBy = "paperReviewer" ,fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<User> reviewers;
	
	@OneToMany(mappedBy = "review_user" , fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Review> reviews;
	
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL )
    @JoinColumn(name = "report_id", nullable = false)
	private Report report;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Topic topic;
	
	@NotNull
    @NotEmpty
	private int revision;
	
	@NotNull
    @NotEmpty
	private String format;
	
	public Paper() {
		
	}
	
	public Paper(String title, User contactAuthor, String contauthname, String contauthemail, String authors, int revision, String format) {
		this.title = title;
		this.contactAuthor = contactAuthor;
		this.authors = authors;
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

	public String getAuthors() {
		return authors;
	}

	public void setAuthors(String authors) {
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

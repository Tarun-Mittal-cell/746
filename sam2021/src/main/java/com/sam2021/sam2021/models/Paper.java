package com.sam2021.sam2021.models;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.hibernate.id.Assigned;

@Entity
@Table(name="Paper")
public class Paper {
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
    @NotEmpty
	private String title;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "contactAuth_id", nullable = false)
	private User contactAuthor;

	@NotNull
    @NotEmpty
	private String contauthemail;
	
	@NotNull
    @NotEmpty
	private String authors;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name = "paper_user",
            joinColumns = {
                    @JoinColumn(name = "paper_id", referencedColumnName = "id",
                            nullable = true, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "user_id", referencedColumnName = "id",
                            nullable = true, updatable = false)})
	private Set<User> users = new HashSet<>();
	
	@OneToMany(mappedBy = "review_user" , fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Review> reviews;
	
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL )
    @JoinColumn(name = "report_id", nullable = true)
	private Report report;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Topic topic;
	
	@NotNull
    @NotEmpty
	private String revision;
	
	@NotNull
    @NotEmpty
	private String format;

	@Type(type = "true_false")
	@Column(columnDefinition = "char(1) default false")
	private boolean assigned;

	@NotNull
    @NotEmpty
	private String filename;
	
	public Paper() {
		
	}
	
	public Paper(String title, User contactAuthor, String contauthname, String contauthemail, String authors, String revision, String format, String filename) {
		this.title = title;
		this.contactAuthor = contactAuthor;
		this.authors = authors;
		this.revision = revision;
		this.format = format;
	}
	public Paper(String title, User contactAuthor, String contauthname, String contauthemail, String authors, String revision, String format, boolean assigned, String filename) {
		this.title = title;
		this.contactAuthor = contactAuthor;
		this.authors = authors;
		this.revision = revision;
		this.format = format;
		this.assigned = assigned;
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

	public Boolean getAssigned() {
		return assigned;
	}

	public String getContauthemail() {
		return contauthemail;
	}


	public Topic getTopic() {
		return topic;
	}
	public Set<User> getUsers() {
		return users;
	}

	public String getFilename() {
		return filename;
	}



	//Setter

	public void setAuthors(String authors) {
		this.authors = authors;
	}

	public Set<User> getReviewers() {
		return users;
	}

	public void setReviewers(Set<User> reviewers) {
		this.users = reviewers;
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

	public String getRevision() {
		return revision;
	}

	public String setRevision(String revision) {
		return this.revision = revision;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public void setAssigned(Boolean assigned) {
		this.assigned = assigned;
	}

	public void setContauthemail(String contauthemail) {
		this.contauthemail = contauthemail;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
}

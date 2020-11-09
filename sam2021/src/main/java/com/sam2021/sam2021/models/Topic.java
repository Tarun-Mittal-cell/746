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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Topic")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    private String description;

    @NotNull
    @NotEmpty
    private Timestamp submission_deadline;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL )
    @JoinColumn(name = "chairman_id", nullable = false)
    private Set<User> chairman;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "members_id", nullable = false)
    private Set<User> members;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "papers_id", nullable = false)
    private Set<Paper> papers;

    @OneToOne(mappedBy = "topic", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private ReviewTemplate reviewTemp;

    public Topic(){
        
    }

    public Topic(String name, String description,Timestamp submission_deadline) {
        this.name = name;
        this.description = description;
        this.submission_deadline = submission_deadline;
    }

    //Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Set<User> getChairman() {
        return chairman;
    }

    public Set<User> getMembers() {
        return members;
    }

    public Set<Paper> getPapers() {
        return papers;
    }

    public Timestamp getSubmission_deadline() {
        return submission_deadline;
    }

    public ReviewTemplate getReviewTemp() {
        return reviewTemp;
    }

    //Setter
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setChairman(Set<User> chairman) {
        this.chairman = chairman;
    }

    public void setMembers(Set<User> members) {
        this.members = members;
    }

    public void setPapers(Set<Paper> papers) {
        this.papers = papers;
    }

    public void setSubmission_deadline(Timestamp submission_deadline) {
        this.submission_deadline = submission_deadline;
    }

    public void setReviewTemp(ReviewTemplate reviewTemp) {
        this.reviewTemp = reviewTemp;
    }

}

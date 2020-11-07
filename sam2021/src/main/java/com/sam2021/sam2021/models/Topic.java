package com.sam2021.sam2021.models;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "chairman_id", nullable = false)
    private User chairman;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "members_id", nullable = false)
    private User members;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "papers_id", nullable = false)
    private Paper papers;

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

    public User getChairman() {
        return chairman;
    }

    public User getMembers() {
        return members;
    }

    public Paper getPapers() {
        return papers;
    }

    public Timestamp getSubmission_deadline() {
        return submission_deadline;
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

    public void setChairman(User chairman) {
        this.chairman = chairman;
    }

    public void setMembers(User members) {
        this.members = members;
    }

    public void setPapers(Paper papers) {
        this.papers = papers;
    }

    public void setSubmission_deadline(Timestamp submission_deadline) {
        this.submission_deadline = submission_deadline;
    }

}

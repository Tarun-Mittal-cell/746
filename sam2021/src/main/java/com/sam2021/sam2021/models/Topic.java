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

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL )
    @JoinColumn(name = "chairman_id", nullable = true)
    private User chairman;

    @OneToMany(mappedBy = "papers", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Paper> papers;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "reviewtemp_id", nullable = true)
    private ReviewTemplate reviewTemp;

    @OneToOne(mappedBy = "topic", fetch = FetchType.LAZY,cascade = CascadeType.ALL )
	private Deadlines deadlines;


    public Topic(){
        
    }

    public Topic(String name, String description) {
        this.name = name;
        this.description = description;
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

    public Set<Paper> getPapers() {
        return papers;
    }


    public ReviewTemplate getReviewTemp() {
        return reviewTemp;
    }

    public Deadlines getDeadlines() {
        return deadlines;
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

    public void setPapers(Set<Paper> papers) {
        this.papers = papers;
    }

    public void setReviewTemp(ReviewTemplate reviewTemp) {
        this.reviewTemp = reviewTemp;
    }

    public void setDeadlines(Deadlines deadlines) {
        this.deadlines = deadlines;
    }
}

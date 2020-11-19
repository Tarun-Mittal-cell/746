package com.sam2021.sam2021.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "ReviewTemplate")
public class ReviewTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String filename;


    @OneToMany(mappedBy = "reviewTemp", fetch = FetchType.LAZY)
    private Set<Topic> topic;

    public ReviewTemplate(){
        
    }

    public ReviewTemplate(String filename) {
        this.filename = filename;
    }

    public ReviewTemplate(Long id, String filename) {
        this.id = id;
        this.filename = filename;
    }

    //Getter

    public Long getId() {
        return id;
    }

    public String getFilename() {
        return filename;
    }


    public Set<Topic> getTopic() {
        return topic;
    }

    //Setter

    public void setId(Long id) {
        this.id = id;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public void setTopic(Set<Topic> topic) {
        this.topic = topic;
    }


}

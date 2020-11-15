package com.sam2021.sam2021.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "ReviewTemplate")
public class ReviewTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String filename;


    @OneToOne(mappedBy = "reviewTemp", fetch = FetchType.LAZY, optional = false)
    private Topic topic;

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


    public Topic getTopic() {
        return topic;
    }

    //Setter

    public void setId(Long id) {
        this.id = id;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }


}

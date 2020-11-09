package com.sam2021.sam2021.models;

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
@Table(name = "ReviewTemplate")
public class ReviewTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @NotEmpty
    private String templateName;

    private String filename;


    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "topic_id", nullable = false)
    private Topic topic;

    public ReviewTemplate(String templateName, String filename) {
        this.templateName = templateName;
        this.filename = filename;
    }

    //Getter

    public Long getId() {
        return id;
    }
    public String getTemplateName() {
        return templateName;
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

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

}

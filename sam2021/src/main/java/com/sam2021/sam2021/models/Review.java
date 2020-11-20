package com.sam2021.sam2021.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@Entity
@Table(name = "Review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull
    private String pcmReview;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "review_id", nullable = false)
    private User review_user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Paper paper;

    public Review() {
    }

    public Review(List<String> pcmReview) {
        setPcmReview(pcmReview);
    }

    // Getter
    public Long getId() {
        return id;
    }

    public Paper getPaper() {
        return paper;
    }

    public List<String> getPcmReview() {
        JSONParser parser = new JSONParser();
        try {
            JSONArray array = (JSONArray)parser.parse(pcmReview);
            String [] textArray = (String[])array.toArray();
            List<String> text = new ArrayList<>();
            for(String s : textArray){
                text.add(s);
            }
            return text;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return new ArrayList<String>();
    }
    public User getReview_user() {
        return review_user;
    }

    //Setter
    public void setId(Long id) {
        this.id = id;
    }
    public void setPaper(Paper paper) {
        this.paper = paper;
    }
    public void setPcmReview(List<String> pcmReview) {
        this.pcmReview = JSONArray.toJSONString(pcmReview);
    }
    public void setReview_user(User review_user) {
        this.review_user = review_user;
    }

}

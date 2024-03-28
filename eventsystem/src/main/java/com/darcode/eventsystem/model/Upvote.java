package com.darcode.eventsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "upvote")
public class Upvote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long upvoteid;
    private Long eventid;
    private Long userid;

    // Default constructor
    public Upvote() {
    }

    // Getters and setters for upvoteid
    public Long getUpvoteid() {
        return upvoteid;
    }

    public void setUpvoteid(Long upvoteid) {
        this.upvoteid = upvoteid;
    }

    // Getters and setters for other fields
    public Long getEventid() {
        return eventid;
    }

    public void setEventid(Long eventid) {
        this.eventid = eventid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }
}

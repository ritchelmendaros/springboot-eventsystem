package com.darcode.eventsystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eventid")
    private Long eventId;

    @Column(name = "eventName")
    private String eventName;

    @Column(name = "eventDescription")
    private String eventDescription;

    @Column(name = "eventDate")
    private String eventDate;

    @Column(name = "organizerID")
    private Long organizerId;

    @Column(name = "eventStatus")
    private String eventStatus;

    @Column(name = "location")
    private String location;

    // Getters and setters
    public Event() {

    }

    public Long getEventId() {
        return eventId;
    }

    public Event(Long eventId, String eventName, String eventDescription, String eventDate, Long organizerId,
            String eventStatus, String location) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.eventDate = eventDate;
        this.organizerId = organizerId;
        this.eventStatus = eventStatus;
        this.location = location;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDate() {
        return eventDate;
    }

    public Long getOrganizerId() {
        return organizerId;
    }

    public void setOrganizerId(Long organizerId) {
        this.organizerId = organizerId;
    }

    public String getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(String eventStatus) {
        this.eventStatus = eventStatus;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }
}

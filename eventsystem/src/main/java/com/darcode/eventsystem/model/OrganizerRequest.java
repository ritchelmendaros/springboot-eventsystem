package com.darcode.eventsystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "organizerrequest")
public class OrganizerRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "requestid")
    public Long requestid;
    @Column(name = "userid")
    public Long userid;
    @Column(name = "request_status")
    public String requestStatus;
    @Column(name = "hasRequested")
    public Long hasRequested;

    public OrganizerRequest() {
    }

    public OrganizerRequest(Long requestid, Long userid, String requestStatus, Long hasRequested) {
        this.requestid = requestid;
        this.userid = userid;
        this.requestStatus = requestStatus;
        this.hasRequested = hasRequested;
    }

    public Long getRequestid() {
        return requestid;
    }

    public void setRequestid(Long requestid) {
        this.requestid = requestid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    public Long getHasRequested() {
        return hasRequested;
    }

    public void setHasRequested(Long hasRequested) {
        this.hasRequested = hasRequested;
    }

}

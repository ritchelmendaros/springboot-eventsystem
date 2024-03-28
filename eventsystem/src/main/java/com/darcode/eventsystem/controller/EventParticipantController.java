package com.darcode.eventsystem.controller;

import com.darcode.eventsystem.model.EventParticipant;
import com.darcode.eventsystem.service.EventParticipantService;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/eventparticipants")
public class EventParticipantController {

    private final EventParticipantService eventParticipantService;

    @Autowired
    public EventParticipantController(EventParticipantService eventParticipantService) {
        this.eventParticipantService = eventParticipantService;
    }

    @PostMapping("/check")
    public ResponseEntity<?> checkUserIdExistsInEventParticipants(@RequestBody Long userId) {
        List<Long> eventIds = eventParticipantService.getEventIdsByUserId(userId);
        if (eventIds != null && !eventIds.isEmpty()) {
            return ResponseEntity.ok().body(eventIds);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addParticipantToEvent(@RequestBody EventParticipant eventParticipant) {
        try {
            EventParticipant addedParticipant = eventParticipantService.addParticipantToEvent(eventParticipant);
            return ResponseEntity.status(HttpStatus.CREATED).body(addedParticipant);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to add participant to event: " + e.getMessage());
        }
    }

    @GetMapping("/getall")
    public ResponseEntity<List<EventParticipant>> getAllParticipantDetails() {
        try {
            List<EventParticipant> participants = eventParticipantService.getAllParticipantDetails();
            return ResponseEntity.ok().body(participants);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.emptyList());
        }
    }
}
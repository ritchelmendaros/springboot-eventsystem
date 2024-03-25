package com.darcode.eventsystem.controller;

import com.darcode.eventsystem.service.EventParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
        Long eventId = eventParticipantService.getEventIdByUserId(userId);
        if (eventId != null) {
            return ResponseEntity.ok().body(eventId);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
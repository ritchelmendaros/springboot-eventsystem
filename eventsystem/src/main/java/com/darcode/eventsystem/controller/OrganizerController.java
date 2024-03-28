package com.darcode.eventsystem.controller;

import com.darcode.eventsystem.model.Event;
import com.darcode.eventsystem.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/organizer")
public class OrganizerController {

    private final EventService eventService;

    @Autowired
    public OrganizerController(EventService eventService) {
        this.eventService = eventService;
    }

    public ResponseEntity<?> addEvent(@RequestBody Event event) {
        try {
            System.out.println("Received request to add event: " + event); // Add this line for debugging
            Event addedEvent = eventService.saveEvent(event);
            return ResponseEntity.status(HttpStatus.CREATED).body(addedEvent);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to add event: " + e.getMessage());
        }
    }

    @DeleteMapping("/events/delete/{eventId}")
    public ResponseEntity<?> deleteEvent(@PathVariable Long eventId) {
        try {
            eventService.deleteEvent(eventId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to delete event: " + e.getMessage());
        }
    }
}
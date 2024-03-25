package com.darcode.eventsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.darcode.eventsystem.model.OrganizerRequest;
import com.darcode.eventsystem.service.OrganizerRequestService;

@RestController
@RequestMapping("/api/organizer-requests")
public class OrganizerRequestController {

    private final OrganizerRequestService organizerRequestService;

    @Autowired
    public OrganizerRequestController(OrganizerRequestService organizerRequestService) {
        this.organizerRequestService = organizerRequestService;
    }

    @PostMapping("/request")
    public ResponseEntity<String> requestOrganizer(@RequestBody OrganizerRequest organizerRequest) {
        try {
            organizerRequestService.save(organizerRequest);
            return ResponseEntity.ok("Organizer request sent successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error sending organizer request: " + e.getMessage());
        }
    }
}

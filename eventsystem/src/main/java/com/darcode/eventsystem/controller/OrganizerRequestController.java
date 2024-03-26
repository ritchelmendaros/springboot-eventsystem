package com.darcode.eventsystem.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/userIds")
    public ResponseEntity<?> getAllUserIdsWithStatus() {
        try {
            List<OrganizerRequest> organizerRequests = organizerRequestService.getAllOrganizerRequests();
            List<Map<String, Object>> userIdsAndStatus = new ArrayList<>();

            for (OrganizerRequest request : organizerRequests) {
                Map<String, Object> userData = new HashMap<>();
                userData.put("userid", request.getUserid());
                userData.put("request_status", request.getRequestStatus());
                userIdsAndStatus.add(userData);
            }

            return ResponseEntity.ok(userIdsAndStatus);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error fetching user IDs with status: " + e.getMessage());
        }
    }

}

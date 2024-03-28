package com.darcode.eventsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.darcode.eventsystem.model.Upvote;
import com.darcode.eventsystem.service.UpvoteService;

@RestController
@RequestMapping("/api/upvotes")
public class UpvoteController {

    private final UpvoteService upvoteService;

    @Autowired
    public UpvoteController(UpvoteService upvoteService) {
        this.upvoteService = upvoteService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addUpvote(@RequestBody Upvote upvote) {
        try {
            Upvote addedUpvote = upvoteService.addUpvote(upvote);
            return ResponseEntity.status(HttpStatus.CREATED).body(addedUpvote);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to add upvote: " + e.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Upvote>> getAllUpvotes() {
        try {
            List<Upvote> upvotes = upvoteService.getAllUpvotes();
            return ResponseEntity.ok().body(upvotes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

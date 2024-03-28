package com.darcode.eventsystem.service;
import com.darcode.eventsystem.service.OrganizerService;

import com.darcode.eventsystem.model.Event;
import com.darcode.eventsystem.repository.EventRepository;
import com.darcode.eventsystem.repository.OrganizerRepository;
import com.darcode.eventsystem.repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizerService {

    private final OrganizerRepository organizerRepository;
    private final EventRepository eventRepository;
     private static final Logger logger = LoggerFactory.getLogger(OrganizerService.class);

    @Autowired
    public OrganizerService(OrganizerRepository organizerRepository, EventRepository eventRepository) {
        this.organizerRepository = organizerRepository;
        this.eventRepository = eventRepository;
    }
    public void createEvent(Event event) {
        try {
            // Add additional logic if needed, such as validation
            eventRepository.save(event);
            logger.info("Event created successfully: {}", event.getEventName());
        } catch (Exception e) {
            logger.error("Failed to create event: {}", e.getMessage());
            throw new RuntimeException("Failed to create event");
        }
    }
    
}

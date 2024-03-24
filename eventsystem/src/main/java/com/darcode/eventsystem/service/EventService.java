package com.darcode.eventsystem.service;

import com.darcode.eventsystem.model.Event;
import com.darcode.eventsystem.repository.EventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private final EventRepository eventRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(EventService.class);

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getAllEvents() {
        try {
            List<Event> events = eventRepository.findAll();
            LOGGER.info("Number of events retrieved: {}", events.size());
            return events;
        } catch (Exception e) {
            LOGGER.error("Error occurred while fetching events: {}", e.getMessage());
            throw e;
        }
    }

    // Other methods omitted for brevity
}

package com.darcode.eventsystem.service;

import com.darcode.eventsystem.model.Event;
import com.darcode.eventsystem.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getAllEvents() {
        List<Event> events = eventRepository.findAll();
        System.out.println("Number of events retrieved: " + events.size());
        return events;
    }

    public Optional<Event> getEventById(Long id) {
        return eventRepository.findById(id);
    }

    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    public List<Event> getEventsByEventIds(List<Long> eventIds) {
        return eventRepository.findAllById(eventIds);
    }

    public void cancelEvent(Long eventId) {
        Optional<Event> optionalEvent = eventRepository.findById(eventId);
        if (optionalEvent.isPresent()) {
            Event event = optionalEvent.get();
            event.setEventStatus("Cancelled");
            eventRepository.save(event);
        } else {
            throw new IllegalArgumentException("Event with ID " + eventId + " not found.");
        }
    }

    public List<Long> getUserIdsByEventId(Long eventId) {
        return eventRepository.findUserIdsByEventId(eventId);
    }

    public List<Event> getEventsByOrganizerId(Long userId) {
        return eventRepository.findByOrganizerId(userId);
    }

    public Event addEvent(Event event) {
        // You can add additional logic/validation here if needed
        return eventRepository.save(event);
    }

}

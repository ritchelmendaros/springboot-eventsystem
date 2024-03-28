package com.darcode.eventsystem.service;

import com.darcode.eventsystem.model.EventParticipant;
import com.darcode.eventsystem.repository.EventParticipantRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventParticipantService {

    private final EventParticipantRepository eventParticipantRepository;

    @Autowired
    public EventParticipantService(EventParticipantRepository eventParticipantRepository) {
        this.eventParticipantRepository = eventParticipantRepository;
    }

    public List<Long> getEventIdsByUserId(Long userId) {
        List<EventParticipant> eventParticipants = eventParticipantRepository.findAllByUserID(userId);
        List<Long> eventIds = new ArrayList<>();
        for (EventParticipant eventParticipant : eventParticipants) {
            eventIds.add(eventParticipant.getEventID());
        }
        return eventIds;
    }

    public EventParticipant addParticipantToEvent(EventParticipant eventParticipant) {
        return eventParticipantRepository.save(eventParticipant);
    }

    public List<EventParticipant> getAllParticipantDetails() {
        return eventParticipantRepository.findAll();
    }

}
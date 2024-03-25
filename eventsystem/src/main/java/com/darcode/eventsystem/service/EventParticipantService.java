package com.darcode.eventsystem.service;

import com.darcode.eventsystem.model.EventParticipant;
import com.darcode.eventsystem.repository.EventParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventParticipantService {

    private final EventParticipantRepository eventParticipantRepository;

    @Autowired
    public EventParticipantService(EventParticipantRepository eventParticipantRepository) {
        this.eventParticipantRepository = eventParticipantRepository;
    }

    public Long getEventIdByUserId(Long userId) {
        EventParticipant eventParticipant = eventParticipantRepository.findByUserID(userId);
        if (eventParticipant != null) {
            return eventParticipant.getEventID();
        } else {
            return null;
        }
    }
}
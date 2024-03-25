package com.darcode.eventsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.darcode.eventsystem.model.OrganizerRequest;
import com.darcode.eventsystem.repository.OrganizerRequestRepository;

@Service
public class OrganizerRequestService {

    private final OrganizerRequestRepository organizerRequestRepository;

    @Autowired
    public OrganizerRequestService(OrganizerRequestRepository organizerRequestRepository) {
        this.organizerRequestRepository = organizerRequestRepository;
    }

    public void save(OrganizerRequest organizerRequest) {
        organizerRequestRepository.save(organizerRequest);
    }
}

package com.darcode.eventsystem.service;

import java.util.List;

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

    public List<OrganizerRequest> getAllOrganizerRequests() {
        return organizerRequestRepository.findAll();
    }

    public List<Long> getAllUserIds() {
        // TODO: Implement logic to extract user IDs from the organizer requests
        throw new UnsupportedOperationException("Method 'getAllUserIds' not yet implemented");
    }

}

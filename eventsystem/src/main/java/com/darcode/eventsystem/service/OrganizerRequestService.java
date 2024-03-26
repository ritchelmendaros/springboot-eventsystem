package com.darcode.eventsystem.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory; // Import LoggerFactory
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.darcode.eventsystem.model.OrganizerRequest;
import com.darcode.eventsystem.model.User;
import com.darcode.eventsystem.repository.OrganizerRequestRepository;
import com.darcode.eventsystem.repository.UserRepository;

@Service
public class OrganizerRequestService {

    private final OrganizerRequestRepository organizerRequestRepository;
    private final UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(OrganizerRequestService.class); // Instantiate logger

    @Autowired
    public OrganizerRequestService(OrganizerRequestRepository organizerRequestRepository,
            UserRepository userRepository) {
        this.organizerRequestRepository = organizerRequestRepository;
        this.userRepository = userRepository;
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

    public void updateStatus(Long userId, String newStatus) {
        OrganizerRequest request = organizerRequestRepository.findByUserid(userId);
        if (request != null) {
            request.setRequestStatus(newStatus);
            organizerRequestRepository.save(request);

            if ("approved".equalsIgnoreCase(newStatus)) {
                User user = userRepository.findById(userId).orElse(null);
                if (user != null) {
                    user.setUserType(1);
                    userRepository.save(user);

                    logger.info("User type updated for user with ID {}: {}", userId, user.getUserType());
                } else {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with ID: " + userId);
                }
            }
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User request not found with ID: " + userId);
        }
    }
}

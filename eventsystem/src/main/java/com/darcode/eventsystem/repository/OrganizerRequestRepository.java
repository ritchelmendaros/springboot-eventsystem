package com.darcode.eventsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.darcode.eventsystem.model.OrganizerRequest;

public interface OrganizerRequestRepository extends JpaRepository<OrganizerRequest, Long> {
}
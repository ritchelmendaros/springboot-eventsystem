package com.darcode.eventsystem.repository;

import com.darcode.eventsystem.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizerRepository extends JpaRepository<Event, Long> {
    // You can add custom repository methods here if needed
}

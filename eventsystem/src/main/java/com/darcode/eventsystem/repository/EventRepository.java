package com.darcode.eventsystem.repository;

import com.darcode.eventsystem.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    // Your custom query methods (if any)
}

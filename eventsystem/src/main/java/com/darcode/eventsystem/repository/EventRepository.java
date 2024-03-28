package com.darcode.eventsystem.repository;

import com.darcode.eventsystem.model.Event;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    List<Long> findUserIdsByEventId(Long eventId);
}

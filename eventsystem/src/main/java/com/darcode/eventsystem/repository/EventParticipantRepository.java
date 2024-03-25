package com.darcode.eventsystem.repository;

import com.darcode.eventsystem.model.EventParticipant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventParticipantRepository extends JpaRepository<EventParticipant, Long> {

    boolean existsByUserID(Long userID);

    EventParticipant findByUserID(Long userID);
}

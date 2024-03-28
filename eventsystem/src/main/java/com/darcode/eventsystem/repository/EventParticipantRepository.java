package com.darcode.eventsystem.repository;

import com.darcode.eventsystem.model.EventParticipant;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventParticipantRepository extends JpaRepository<EventParticipant, Long> {
    List<EventParticipant> findAllByUserID(Long userID);

}

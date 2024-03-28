package com.darcode.eventsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.darcode.eventsystem.model.Upvote;

@Repository
public interface UpvoteRepository extends JpaRepository<Upvote, Long> {

}

package com.darcode.eventsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darcode.eventsystem.model.Upvote;
import com.darcode.eventsystem.repository.UpvoteRepository;

@Service
public class UpvoteService {

    private final UpvoteRepository upvoteRepository;

    @Autowired
    public UpvoteService(UpvoteRepository upvoteRepository) {
        this.upvoteRepository = upvoteRepository;
    }

    public Upvote addUpvote(Upvote upvote) {
        return upvoteRepository.save(upvote);
    }

    public List<Upvote> getAllUpvotes() {
        return upvoteRepository.findAll();
    }

}

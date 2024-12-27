package com.springboot.HBO_app.service;

import com.springboot.HBO_app.model.Poll;
import com.springboot.HBO_app.repository.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PollService {

    private final PollRepository pollRepository;

    @Autowired
    public PollService(PollRepository pollRepository) {
        this.pollRepository = pollRepository;
    }


    // Create a new poll
    public Poll createPoll(Poll poll) {
        return pollRepository.save(poll);
    }

    // Get all polls
    public List<Poll> getAllPolls() {
        return pollRepository.findAll();
    }

    // Get a poll by ID
    public Poll getPollById(Long id) {
        return pollRepository.findById(id).orElse(null);
    }


}

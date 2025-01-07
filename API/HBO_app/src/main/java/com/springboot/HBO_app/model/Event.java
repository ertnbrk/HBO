package com.springboot.HBO_app.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;

    private String eventName;
    private String eventCreator;

    @Column(name = "voting_deadline")
    private LocalDateTime votingDeadline;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<EventDate> eventDates;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<UserVote> userVotes;

    public Event(Long eventId) {
        this.eventId = eventId;
    }

    public Event() {

    }

    // getters and setters
}


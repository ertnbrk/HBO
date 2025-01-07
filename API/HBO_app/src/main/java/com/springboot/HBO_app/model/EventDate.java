package com.springboot.HBO_app.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class EventDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dateId;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    private LocalDate eventDate;
    private LocalTime eventTime;

    public EventDate(Long dateId) {
        this.dateId = dateId;
    }

    public EventDate() {

    }


    // getters and setters
}

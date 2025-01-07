package com.springboot.HBO_app.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class UserVote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long voteId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @ManyToOne
    @JoinColumn(name = "date_id", nullable = false)
    private EventDate eventDate;

    private LocalDateTime voteTimestamp;

    // getters and setters
    // Getter method for 'user'
    public User getUser() {
        return user;
    }

    // Setter method for 'user'
    public void setUser(User user) {
        this.user = user;
    }

    public void setEvent(Event event) {

    }

    public void setEventDate(EventDate eventDate) {

    }
}

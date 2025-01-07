package com.springboot.HBO_app.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "\"users\"")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String email;
    private String fullName;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserVote> userVotes;


    public User(Long userId) {
        this.userId = userId;
    }

    public User() {

    }


    // getters and setters
}

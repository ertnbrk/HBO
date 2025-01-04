package com.springboot.HBO_app.repository;

import com.springboot.HBO_app.model.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PollRepository extends JpaRepository<Poll, Long> {

    List<Poll> findByCreatedById(Long userId); // Find polls by the user who created them
}

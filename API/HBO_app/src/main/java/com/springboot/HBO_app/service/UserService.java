package com.springboot.HBO_app.service;

import com.springboot.HBO_app.model.User;
import com.springboot.HBO_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);  // Return user or null if not found
    }
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);  // Return the user by email
    }
    public User saveUser(User user) {
        return userRepository.save(user);
    }

   
}

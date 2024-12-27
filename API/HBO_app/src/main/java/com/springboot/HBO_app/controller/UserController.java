package com.springboot.HBO_app.controller;

import com.springboot.HBO_app.model.User;
import com.springboot.HBO_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public User login(@RequestParam String email, @RequestParam String password) {
        User user = userService.findByEmail(email);
        // Here, you should add password verification logic
        return user;
    }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
    @GetMapping("/email/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);  // Fetch user by email
    }
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.saveUser(user);
    }
}

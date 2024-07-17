package com.rss.resurv.controller;

import com.rss.resurv.exception.ResourceNotFoundException;
import com.rss.resurv.model.User;
import com.rss.resurv.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

// IDEA doesn't recommend using @Autowired annotation because it injects beans directly into fields
// and "hides" dependencies, which is bad design, thus the @SuppressWarnings annotation
@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/ReSurv/accounts")
public class UserController {
    @Autowired // parent class
    private UserRepository userRepository;

    // get all Users
    @GetMapping("/")
    public List<User> getAllUsers() { return userRepository.findAll(); }

    // get Users by id
    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable UUID id) {
        // get user if exists; else, throw exception
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with id " + id + " does not exist."));
        return ResponseEntity.ok(user);
    }

    // create new User
    @PostMapping("/ReSurv/register")
    User createUser(@RequestBody User user) { return userRepository.save(user); }

    // delete existing User
    @DeleteMapping("{id}")
    public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable UUID id) {
        // get user if exists; else, throw exception
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with id " + id + " does not exist."));
        // delete user
        userRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    // update User
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable UUID id, @RequestBody User userData) {
        // get user if exists; else, throw exception
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with id " + id + " does not exist."));
        // update user attributes
        user.setEmail(userData.getEmail());
        user.setFirstName(userData.getFirstName());
        user.setLastName(userData.getLastName());
        user.setPassword(userData.getPassword());
        // save changes to repository
        User updatedUser = userRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }
}

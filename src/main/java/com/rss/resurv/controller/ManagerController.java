package com.rss.resurv.controller;

import com.rss.resurv.exception.ResourceNotFoundException;
import com.rss.resurv.model.Manager;
import com.rss.resurv.repository.ManagerRepository;
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
@RequestMapping("/ReSurv/accounts/managers")
public class ManagerController {
    @Autowired // parent class
    private ManagerRepository managerRepository;

    // get all Managers
    @GetMapping("")
    public List<Manager> getAllManagers() { return managerRepository.findAll(); }

    // get Managers by id
    @GetMapping("{id}")
    public ResponseEntity<Manager> getManagerById(@PathVariable UUID id) {
        // get manager if exists; else, throw exception
        Manager manager = managerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Manager with id " + id + " does not exist."));
        return ResponseEntity.ok(manager);
    }

    // create new Manager
    @PostMapping("/ReSurv/register")
    Manager createManager(@RequestBody Manager manager) { return managerRepository.save(manager); }

    // delete existing Manager
    @DeleteMapping("{id}")
    public ResponseEntity<Map<String, Boolean>> deleteManager(@PathVariable UUID id) {
        // get manager if exists; else, throw exception
        Manager manager = managerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Manager with id " + id + " does not exist."));
        // delete manager
        managerRepository.delete(manager);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    // update Manager
    @PutMapping("/{id}")
    public ResponseEntity<Manager> updateManager(@PathVariable UUID id, @RequestBody Manager managerData) {
        // get manager if exists; else, throw exception
        Manager manager = managerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Manager with id " + id + " does not exist."));
        // update manager attributes
        manager.setEmail(managerData.getEmail());
        manager.setFirstName(managerData.getFirstName());
        manager.setLastName(managerData.getLastName());
        manager.setPassword(managerData.getPassword());
        // save changes to repository
        Manager updatedManager = managerRepository.save(manager);
        return ResponseEntity.ok(updatedManager);
    }
}

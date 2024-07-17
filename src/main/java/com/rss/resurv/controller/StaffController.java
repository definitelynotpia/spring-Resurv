//package com.rss.resurv.controller;
//
//import com.rss.resurv.exception.ResourceNotFoundException;
//import com.rss.resurv.model.Staff;
//import com.rss.resurv.repository.StaffRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.UUID;
//
//// IDEA doesn't recommend using @Autowired annotation because it injects beans directly into fields
//// and "hides" dependencies, which is bad design, thus the @SuppressWarnings annotation
//@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
//@RestController
//@CrossOrigin(origins = "*")
//@RequestMapping("/ReSurv/accounts/staffs")
//public class StaffController {
//    @Autowired // parent class
//    private StaffRepository staffRepository;
//
//    // get all Staffs
//    @GetMapping("")
//    public List<Staff> getAllStaffs() { return staffRepository.findAll(); }
//
//    // get Staffs by id
//    @GetMapping("{id}")
//    public ResponseEntity<Staff> getStaffById(@PathVariable UUID id) {
//        // get staff if exists; else, throw exception
//        Staff staff = staffRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Staff with id " + id + " does not exist."));
//        return ResponseEntity.ok(staff);
//    }
//
//    // create new Staff
//    @PostMapping("/ReSurv/register")
//    Staff createStaff(@RequestBody Staff staff) { return staffRepository.save(staff); }
//
//    // delete existing Staff
//    @DeleteMapping("{id}")
//    public ResponseEntity<Map<String, Boolean>> deleteStaff(@PathVariable UUID id) {
//        // get staff if exists; else, throw exception
//        Staff staff = staffRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Staff with id " + id + " does not exist."));
//        // delete staff
//        staffRepository.delete(staff);
//        Map<String, Boolean> response = new HashMap<>();
//        response.put("deleted", Boolean.TRUE);
//        return ResponseEntity.ok(response);
//    }
//
//    // update Staff
//    @PutMapping("/{id}")
//    public ResponseEntity<Staff> updateStaff(@PathVariable UUID id, @RequestBody Staff staffData) {
//        // get staff if exists; else, throw exception
//        Staff staff = staffRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Staff with id " + id + " does not exist."));
//        // update staff attributes
//        staff.setEmail(staffData.getEmail());
//        staff.setFirstName(staffData.getFirstName());
//        staff.setLastName(staffData.getLastName());
//        staff.setPassword(staffData.getPassword());
//        // save changes to repository
//        Staff updatedStaff = staffRepository.save(staff);
//        return ResponseEntity.ok(updatedStaff);
//    }
//}

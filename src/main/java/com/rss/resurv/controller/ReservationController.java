package com.rss.resurv.controller;

import com.rss.resurv.exception.ResourceNotFoundException;
import com.rss.resurv.model.Reservation;
import com.rss.resurv.model.Customer;
import com.rss.resurv.repository.CustomerRepository;
import com.rss.resurv.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

// IDEA doesn't recommend using @Autowired annotation because it injects beans directly into fields
// and "hides" dependencies, which is bad design, thus the @SuppressWarnings annotation
@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/ReSurv/reservations")
public class ReservationController {
    @Autowired // reservations
    private ReservationRepository reservationRepository;
    @Autowired // customers
    private CustomerRepository customerRepository;

    // get all Reservations
    @GetMapping("")
    public List<Reservation> getAllReservations() { return reservationRepository.findAll(); }

    // get Reservations by id
    @GetMapping("{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable UUID id) {
        // get reservation if exists; else, throw exception
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation with id " + id + " does not exist."));
        return ResponseEntity.ok(reservation);
    }

    // create new Reservation
    @PostMapping("/ReSurv/register")
    Reservation createReservation(@RequestBody Reservation reservation) { return reservationRepository.save(reservation); }

    // delete existing Reservation
    @DeleteMapping("{id}")
    public ResponseEntity<Map<String, Boolean>> deleteReservation(@PathVariable UUID id) {
        // get reservation if exists; else, throw exception
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation with id " + id + " does not exist."));
        // delete reservation
        reservationRepository.delete(reservation);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    // update Reservation
    @PutMapping("/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable UUID id, @RequestBody Reservation reservationData) {
        // get reservation if exists; else, throw exception
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation with id " + id + " does not exist."));
        // set reservation attributes
        reservation.setTableNo(reservationData.getTableNo());
        reservation.setCreationTimestamp(reservationData.getCreationTimestamp());
        reservation.setReservationTimestamp(reservationData.getReservationTimestamp());
        // save changes to repository
        Reservation updatedReservation = reservationRepository.save(reservation);
        return ResponseEntity.ok(updatedReservation);
    }

    // one-to-many relationship (one customer can have many reservations)
    @PutMapping("/{customerId}/{reservationId}")
    Reservation setCustomerToReservation(@PathVariable UUID reservationId, @PathVariable Long customerId) {
        // get reservation and customer objects, else if not exists, throw exceptions
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation with id " + reservationId + " does not exist."));
        Customer customer = customerRepository.findById(Math.toIntExact(customerId))
                .orElseThrow(() -> new ResourceNotFoundException("Customer with id " + customerId + " does not exist."));
        // set customer attribute of reservation
        reservation.setCustomer(customer);
        // save changes to repository
        return reservationRepository.save(reservation);
    }
}

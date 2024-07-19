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



//    // one-to-many relationship (one customer can have many reservations)
//    @PutMapping("/{customerId}/{reservationId}")
//    Reservation setCustomerToReservation(@PathVariable Long reservationId, @PathVariable Long customerId) {
//        // get reservation and customer objects, else if not exists, throw exceptions
//        Reservation reservation = reservationRepository.findById(reservationId)
//                .orElseThrow(() -> new ResourceNotFoundException("Reservation with id " + reservationId + " does not exist."));
//        Customer customer = customerRepository.findById(customerId)
//                .orElseThrow(() -> new ResourceNotFoundException("Customer with id " + customerId + " does not exist."));
//        // set customer attribute of reservation
//        reservation.setCustomer(customer);
//        // save changes to repository
//        return reservationRepository.save(reservation);
//    }
}

package com.rss.resurv.service;

import com.rss.resurv.exception.ResourceNotFoundException;
import com.rss.resurv.model.Customer;
import com.rss.resurv.model.Reservation;
import com.rss.resurv.repository.CustomerRepository;
import com.rss.resurv.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public List<Reservation> findAllReservations(){
        return reservationRepository.findAll();
    }
    public Optional<Reservation> findReservationById(Long id) {
        return reservationRepository.findById(id);
    }

    public Optional<Customer> findCustomerById(Long id) {
        return customerRepository.findById(id);
    }
    

    public Reservation saveReservation(Reservation reservation, Long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found"));
        Reservation newReservation = new Reservation();
        newReservation.setTableNo(reservation.getTableNo());
        newReservation.setCreationTimestamp(LocalDateTime.now());
        newReservation.setCustomer(customer);
        newReservation.setPax(reservation.getPax());
        newReservation.setReservationTimestamp(reservation.getReservationTimestamp());

        return reservationRepository.save(newReservation);
    }

    public Reservation updateReservation(Long id, Reservation reservation) {
        // get reservation if exists; else, throw exception
        Reservation updateReservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation with id " + id + " does not exist."));

        // set reservation attributes
        updateReservation.setTableNo(reservation.getTableNo());
        updateReservation.setCreationTimestamp(LocalDateTime.now());
        updateReservation.setPax(reservation.getPax());
        updateReservation.setReservationTimestamp(reservation.getReservationTimestamp());

        // save changes to repository
        return reservationRepository.save(updateReservation);
    }

    public void deleteById(Long id) {
        // get reservation if exists; else, throw exception
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation with id " + id + " does not exist."));
        // delete reservation
        reservationRepository.delete(reservation);
    }
}

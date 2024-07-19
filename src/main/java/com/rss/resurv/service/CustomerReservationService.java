package com.rss.resurv.service;

import com.rss.resurv.model.Customer;
import com.rss.resurv.model.Reservation;
import com.rss.resurv.repository.CustomerRepository;
import com.rss.resurv.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerReservationService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    public Optional<Reservation> findById(Long id) {
        return reservationRepository.findById(id);
    }

    public Reservation saveReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public Reservation updateReservation(Long id, Reservation reservation) {
        Reservation updatedReservation = reservationRepository.findById(id).orElse(null);
        if (updatedReservation.getCustomer() != null) {
            updatedReservation.setTableNo(reservation.getTableNo());
            updatedReservation.setCustomer(reservation.getCustomer());
            updatedReservation.setPax(reservation.getPax());
            updatedReservation.setPax(reservation.getPax());

            return reservationRepository.save(updatedReservation);

        }

        return reservation;

    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}

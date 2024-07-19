package com.rss.resurv.service;

import com.rss.resurv.exception.ResourceNotFoundException;
import com.rss.resurv.model.Reservation;
import com.rss.resurv.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Optional<Reservation> findById(Long id) {
        return reservationRepository.findById(id);
    }

    public void updateReservation(Long id, Reservation reservationData) {
        // get reservation if exists; else, throw exception
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation with id " + id + " does not exist."));
        // set reservation attributes
        reservation.setTableNo(reservationData.getTableNo());
        reservation.setCreationTimestamp(reservationData.getCreationTimestamp());
        reservation.setReservationTimestamp(reservationData.getReservationTimestamp());
        // save changes to repository
        reservationRepository.save(reservation);
    }

    public void deleteById(Long id) {
        // get reservation if exists; else, throw exception
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation with id " + id + " does not exist."));
        // delete reservation
        reservationRepository.delete(reservation);
    }
}

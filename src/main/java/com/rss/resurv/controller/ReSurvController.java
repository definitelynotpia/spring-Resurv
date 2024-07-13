package com.rss.resurv.controller;

import com.rss.resurv.model.Reservation;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;
import java.util.UUID;

@RestController
@RequestMapping("/")
public class ReSurvController {
    private final List<Reservation> reservations = new ArrayList<>();

    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservations;
    }

    //Insert Query/Create New Reservation
    @PostMapping
    public Reservation addReservation(@RequestBody Reservation reservation) {
        // generate unique id
        UUID reserveID = UUID.randomUUID();
        reservation.setReservationId(reserveID);
        return reservation;
    }
}

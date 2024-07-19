package com.rss.resurv.model;

import jakarta.persistence.*;

import java.util.*;


@Entity
@Table(name = "customers")
public class Customer extends User {

    // Reservation foreign key (one customer, many reservations)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "customer")
    private List<Reservation> reservationList;

    // customer constructor
    public Customer(String firstName, String lastName, String password, String email) {
        // use constructor from parent class
        super(firstName, lastName, password, email);
    }

    public Customer() {

    }

    public List<Reservation> getReservationList() { return reservationList; }
    public void setReservationList(List<Reservation> reservationList) { this.reservationList = reservationList; }
}

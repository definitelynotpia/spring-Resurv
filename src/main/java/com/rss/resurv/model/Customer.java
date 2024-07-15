package com.rss.resurv.model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "Customers")
public class Customer extends User {
    // autoincrement UUID primary key
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID customerId;
    // Reservation foreign key (one customer, many reservations)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "customer")
    private List<Reservation> reservationList;

    // customer constructor
    public Customer(String firstName, String lastName, String password, String email) {
        // use constructor from parent class
        super(firstName, lastName, password, email);
    }

    // getters and setters
    public UUID getCustomerId() {
        return customerId;
    }
    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }
    public List<Reservation> getReservationList() { return reservationList; }
    public void setReservationList(List<Reservation> reservationList) { this.reservationList = reservationList; }
}

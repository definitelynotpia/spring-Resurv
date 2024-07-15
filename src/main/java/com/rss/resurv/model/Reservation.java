package com.rss.resurv.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Reservations")
public class Reservation {
    // autoincrement UUID primary key
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID reservationId;
    // Customer foreign key (one customer, many reservations)
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "customerId", referencedColumnName = "customerId")
    private Customer customer;

    // entity attributes
    @Column(nullable = false, unique = true, name = "tableNo")
    private int tableNo;
    @Column(nullable = false, length = 2, name = "pax")
    private int pax;
    @Column(nullable = false, name = "creationTimestamp")
    private String creationTimestamp; // creation time
    @Column(nullable = false, name = "reservationTimestamp")
    private String reservationTimestamp; // date time

    // reservation constructor
    public Reservation(UUID reservationId, int tableNo, Customer customer, int pax, String timestamp, String reservationTimestamp) {
        this.reservationId = reservationId;
        this.tableNo = tableNo;
        this.customer = customer;
        this.pax = pax;
        this.creationTimestamp = timestamp;
        this.reservationTimestamp = reservationTimestamp;
    }

    // getters and setters
    public UUID getReservationId() {
        return reservationId;
    }
    public void setReservationId(UUID reservationId) {
        this.reservationId = reservationId;
    }
    public int getTableNo() {
        return tableNo;
    }
    public void setTableNo(int tableNo) {
        this.tableNo = tableNo;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public int getPax() {
        return pax;
    }
    public void setPax(int pax) {
        this.pax = pax;
    }
    public String getCreationTimestamp() {
        return creationTimestamp;
    }
    public void setCreationTimestamp(String creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }
    public String getReservationTimestamp() {
        return reservationTimestamp;
    }
    public void setReservationTimestamp(String reservationTimestamp) { this.reservationTimestamp = reservationTimestamp; }
}

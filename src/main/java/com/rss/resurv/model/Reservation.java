package com.rss.resurv.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "reservations")
public class Reservation {
    // autoincrement UUID primary key
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservation_id;

    // Customer foreign key (one customer, many reservations)
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(nullable = false, name = "customer_id", referencedColumnName = "user_id")
    private Customer customer;

    // entity attributes
    @Column(nullable = false, name = "table_no")
    private int tableNo;

    @Column(nullable = false, length = 2, name = "pax")
    private int pax;

    @Column(nullable = false, name = "creation_timestamp")
    private LocalDateTime creationTimestamp; // creation time

    @Column(nullable = false, name = "reservation_timestamp")
    private String reservationTimestamp; // date time

    // reservation constructor
    public Reservation(Long reservationId, int tableNo, Customer customer, int pax, LocalDateTime timestamp, String reservationTimestamp) {
        this.reservation_id = reservationId;
        this.tableNo = tableNo;
        this.customer = customer;
        this.pax = pax;
        this.creationTimestamp = timestamp;
        this.reservationTimestamp = reservationTimestamp;
    }

    public Reservation() {

    }

    // getters and setters
    public Long getReservation_id() {
        return reservation_id;
    }
    public void setReservation_id(Long reservationId) {
        this.reservation_id = reservationId;
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
    public LocalDateTime getCreationTimestamp() {
        return creationTimestamp;
    }
    public void setCreationTimestamp(LocalDateTime creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }
    public String getReservationTimestamp() {
        return reservationTimestamp;
    }
    public void setReservationTimestamp(String reservationTimestamp) { this.reservationTimestamp = reservationTimestamp; }
}

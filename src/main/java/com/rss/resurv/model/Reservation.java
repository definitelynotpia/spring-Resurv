package com.rss.resurv.model;

import java.util.UUID;

public class Reservation {
    private UUID reservationId;
    private int tableNo;
    private int customerId; // foreign key
    private int pax;
    private String timestamp; // creation time
    private String reservationTimestamp; // date time

    public Reservation(UUID reservationId, int tableNo, int customerId, int pax, String timestamp, String reservationTimestamp) {
        this.reservationId = reservationId;
        this.tableNo = tableNo;
        this.customerId = customerId;
        this.pax = pax;
        this.timestamp = timestamp;
        this.reservationTimestamp = reservationTimestamp;
    }

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

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getPax() {
        return pax;
    }

    public void setPax(int pax) {
        this.pax = pax;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getReservationTimestamp() {
        return reservationTimestamp;
    }

    public void setReservationTimestamp(String reservationTimestamp) {
        this.reservationTimestamp = reservationTimestamp;
    }
}

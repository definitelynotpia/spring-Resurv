package com.rss.resurv.model;

import jakarta.persistence.*;

import java.util.UUID;


@Entity
@Table(name = "staffs")
public class Staff extends User{
    // autoincrement Long primary key

    @Column(nullable = false)
    public Long staffId;
    // staff views, edits only

    // staff constructor
    public Staff(String firstName, String lastName, String password, String email) {
        // use constructor from parent class
        super(firstName, lastName, password, email);
    }

    public Staff() {

    }

    // getters and setters
    public Long getStaffId() { return staffId; }
    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }
}

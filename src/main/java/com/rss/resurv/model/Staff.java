package com.rss.resurv.model;

import jakarta.persistence.*;


@Entity
@Table(name = "staffs")
public class Staff extends User{
    // autoincrement Long primary key

    @Column(nullable = false, unique = true, name = "staff_id")
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

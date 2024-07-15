package com.rss.resurv.model;

import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Staffs")
public class Staff extends User{
    // autoincrement UUID primary key
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public UUID staffId;
    // staff views, edits only

    // staff constructor
    public Staff(String firstName, String lastName, String password, String email) {
        // use constructor from parent class
        super(firstName, lastName, password, email);
    }

    // getters and setters
    public UUID getStaffId() { return staffId; }
    public void setStaffId(UUID staffId) {
        this.staffId = staffId;
    }
}

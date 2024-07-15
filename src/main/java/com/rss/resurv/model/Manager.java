package com.rss.resurv.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Managers")
public class Manager extends User {
    // autoincrement UUID primary key
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public UUID managerId;
    // can view, edit, delete

    // manager constructor
    public Manager(String firstName, String lastName, String password, String email) {
        // use constructor from parent class
        super(firstName, lastName, password, email);
    }

    // getters and setters
    public UUID getManagerId() {
        return managerId;
    }
    public void setManagerId(UUID managerId) {
        this.managerId = managerId;
    }
}

package com.rss.resurv.model;

import jakarta.persistence.*;

import java.util.UUID;


@Entity
@Table(name = "managers")
public class Manager extends User {

    public Long managerId;
    // can view, edit, delete

    // manager constructor
    public Manager(String firstName, String lastName, String password, String email) {
        // use constructor from parent class
        super(firstName, lastName, password, email);
    }

    public Manager() {

    }

    // getters and setters
    public Long getManagerId() {
        return managerId;
    }
    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }
}

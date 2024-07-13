package com.rss.resurv.model;

public class Manager extends User {
    // can view, edit, delete
    public int managerId;

    public Manager(int userId, String firstName, String lastName, String password, String email, int managerId) {
        super(userId, firstName, lastName, password, email);
        this.managerId = managerId;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }
}

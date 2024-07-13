package com.rss.resurv.model;

public class Manager extends User {
    // can view, edit, delete
    public int managerId;

    public Manager(int managerId) {
        this.managerId = managerId;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }
}

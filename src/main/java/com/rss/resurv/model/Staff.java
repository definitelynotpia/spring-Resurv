package com.rss.resurv.model;

public class Staff extends User{
    // staff views, edits only
    public int staffId;

    public Staff(int userId, String firstName, String lastName, String password, String email, int staffId) {
        super(userId, firstName, lastName, password, email);
        this.staffId = staffId;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }
}

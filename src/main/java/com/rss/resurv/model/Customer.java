package com.rss.resurv.model;

import java.util.HashMap;
import java.util.Map;

public class Customer extends User {
    private int customerId;

    public Customer(int customerId, int userId, String firstName, String lastName, String password, String email) {
        super(userId, firstName, lastName, password, email);
        this.customerId = customerId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}

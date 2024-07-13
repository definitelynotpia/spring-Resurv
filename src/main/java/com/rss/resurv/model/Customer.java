package com.rss.resurv.model;

import java.util.HashMap;
import java.util.Map;

public class Customer extends User {
    private int customerId;

    public Customer(int customerId) {
        this.customerId = customerId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}

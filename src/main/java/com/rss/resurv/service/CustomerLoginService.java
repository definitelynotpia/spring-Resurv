package com.rss.resurv.service;

import com.rss.resurv.model.Customer;
import com.rss.resurv.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerLoginService {

    @Autowired
    private CustomerRepository customerRepository;

    public String validateLogin(String email, String password) {
        List<Customer> customers = customerRepository.findByEmailAndPassword(email, password);

        if (customers.isEmpty()) {
            return "Invalid email or password";
        }
        return "welcome";
    }
}

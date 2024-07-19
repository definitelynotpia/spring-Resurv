package com.rss.resurv.service;

import com.rss.resurv.model.Customer;
import com.rss.resurv.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerRegisterService {

    @Autowired
    private CustomerRepository customerRepository;

    public String CustomerRegister(Customer customer) {
        Customer userCustomer = new Customer();
        userCustomer.setFirstName(customer.getFirstName());
        userCustomer.setLastName(customer.getLastName());
        userCustomer.setEmail(customer.getEmail());
        userCustomer.setPassword(customer.getPassword());

        customerRepository.save(userCustomer);

        return "Customer Registration Successful!";
    }


}

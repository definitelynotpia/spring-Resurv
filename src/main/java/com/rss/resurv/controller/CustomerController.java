package com.rss.resurv.controller;

import com.rss.resurv.exception.ResourceNotFoundException;
import com.rss.resurv.model.Customer;
import com.rss.resurv.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// IDEA doesn't recommend using @Autowired annotation because it injects beans directly into fields
// and "hides" dependencies, which is bad design, thus the @SuppressWarnings annotation
@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/ReSurv/accounts/customers")
public class CustomerController {
    @Autowired // parent class
    private CustomerRepository customerRepository;

    // get all Customers
    @GetMapping("/")
    public List<Customer> getAllCustomers() {

        String test = "Hello";
        return customerRepository.findAll();
    }

    // get Customers by id
    @GetMapping("{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        // get customer if exists; else, throw exception
        Customer customer = customerRepository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new ResourceNotFoundException("Customer with id " + id + " does not exist."));
        return ResponseEntity.ok(customer);
    }

    // create new Customer
    @PostMapping("/ReSurv/register")
    Customer createCustomer(@RequestBody Customer customer) { return customerRepository.save(customer); }

    // delete existing Customer
    @DeleteMapping("{id}")
    public ResponseEntity<Map<String, Boolean>> deleteCustomer(@PathVariable Long id) {
        // get customer if exists; else, throw exception
        Customer customer = customerRepository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new ResourceNotFoundException("Customer with id " + id + " does not exist."));
        // delete customer
        customerRepository.delete(customer);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    // update Customer
    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customerData) {
        // get customer if exists; else, throw exception
        Customer customer = customerRepository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new ResourceNotFoundException("Customer with id " + id + " does not exist."));
        // update customer attributes
        customer.setEmail(customerData.getEmail());
        customer.setFirstName(customerData.getFirstName());
        customer.setLastName(customerData.getLastName());
        customer.setPassword(customerData.getPassword());
        // save changes to repository
        Customer updatedCustomer = customerRepository.save(customer);
        return ResponseEntity.ok(updatedCustomer);
    }
}

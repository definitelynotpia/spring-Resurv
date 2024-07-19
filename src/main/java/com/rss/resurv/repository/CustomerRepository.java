package com.rss.resurv.repository;

import com.rss.resurv.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByEmailAndPassword(String email, String password);
}

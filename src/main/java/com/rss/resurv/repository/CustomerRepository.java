package com.rss.resurv.repository;

import com.rss.resurv.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByEmailAndPassword(String email, String password);

    Customer findByEmail(String email);
}

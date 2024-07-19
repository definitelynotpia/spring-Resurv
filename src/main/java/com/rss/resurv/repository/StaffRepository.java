package com.rss.resurv.repository;

import com.rss.resurv.model.Customer;
import com.rss.resurv.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface StaffRepository extends JpaRepository<Staff, Long> {
    List<Staff> findByEmailAndPassword(String email, String password);

    Staff findByEmail(String email);
}

package com.rss.resurv.repository;

import com.rss.resurv.model.Manager;
import com.rss.resurv.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
    List<Manager> findByEmailAndPassword(String email, String password);

    Manager findByEmail(String email);
}

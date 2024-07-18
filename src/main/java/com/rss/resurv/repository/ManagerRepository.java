package com.rss.resurv.repository;

import com.rss.resurv.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
}

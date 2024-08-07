package com.rss.resurv.repository;

import com.rss.resurv.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}

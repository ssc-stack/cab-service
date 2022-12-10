package com.assignment.cabservice.repository;

import com.assignment.cabservice.model.Booking;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Transactional
public interface BookingRepository extends JpaRepository<Booking,Integer> {
    List<Booking> findByUsername(String username);
    void deleteByUsername(String username);
}

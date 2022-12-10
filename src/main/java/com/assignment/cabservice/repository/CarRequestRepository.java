package com.assignment.cabservice.repository;

import com.assignment.cabservice.model.CarRequest;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface CarRequestRepository extends JpaRepository<CarRequest,Integer> {
}

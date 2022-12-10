package com.assignment.cabservice.repository;

import com.assignment.cabservice.model.CarRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRequestRepository extends JpaRepository<CarRequest,Integer> {
}

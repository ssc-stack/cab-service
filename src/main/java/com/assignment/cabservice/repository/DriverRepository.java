package com.assignment.cabservice.repository;

import com.assignment.cabservice.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver,Integer> {
}

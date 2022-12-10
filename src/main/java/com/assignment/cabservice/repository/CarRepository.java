package com.assignment.cabservice.repository;

import com.assignment.cabservice.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car,Integer> {
    //List<Car> findBySeatingCapacityAndavailableForBooking(int seatingCapacity,boolean availableForBooking);
    List<Car> findBySeatingCapacityAndAvailableForBookingTrue(int seatingCapacity);

    List<Car> findByIdIn(List<Integer> carIds);
}

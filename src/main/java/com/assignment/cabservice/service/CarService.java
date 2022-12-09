package com.assignment.cabservice.service;

import com.assignment.cabservice.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CarService implements ICarService {


    @Override
    public void addCar(String model, String color, Integer seatingCapacity, Integer driverId) {
        //carRepository.save();
    }

    @Override
    public void deleteById(int id) {

    }
}

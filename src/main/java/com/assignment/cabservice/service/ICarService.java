package com.assignment.cabservice.service;

public interface ICarService {
    public void addCar(String model, String color, Integer seatingCapacity, Integer driverId);
    public void deleteById(int id);
}

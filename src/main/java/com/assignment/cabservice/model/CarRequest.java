package com.assignment.cabservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class CarRequest {
    @Id
    @GeneratedValue
    private int id;
    private int driverId;
    private int carId;
    private String requestStatus;

    public CarRequest() {}

    public CarRequest(int id, int driverId, int carId, String requestStatus) {
        this.id = id;
        this.driverId = driverId;
        this.carId = carId;
        this.requestStatus = requestStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    @Override
    public String toString() {
        return "CarRequest{" +
                "id=" + id +
                ", driverId=" + driverId +
                ", carId=" + carId +
                ", requestStatus='" + requestStatus + '\'' +
                '}';
    }
}

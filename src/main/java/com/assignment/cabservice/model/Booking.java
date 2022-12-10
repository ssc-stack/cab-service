package com.assignment.cabservice.model;

import jakarta.persistence.*;

@Entity
public class Booking {

    @Id
    @GeneratedValue
    private Integer id;
    private String username;
    private Integer carId;
    private Integer driverId;
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", username=" + username +
                ", carId=" + carId +
                ", driverId=" + driverId +
                ", status='" + status + '\'' +
                '}';
    }
}

package com.assignment.cabservice.dao;

import com.assignment.cabservice.model.Car;

import java.util.List;

public class DriverUseCarsDao {
    private int driverId;
    private String driverName;
    private List<Car> usedCars;

    public DriverUseCarsDao() {}

    public DriverUseCarsDao(int driverId, String driverName, List<Car> usedCars) {
        this.driverId = driverId;
        this.driverName = driverName;
        this.usedCars = usedCars;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public List<Car> getUsedCars() {
        return usedCars;
    }

    public void setUsedCars(List<Car> usedCars) {
        this.usedCars = usedCars;
    }

    @Override
    public String toString() {
        return "DriverUseCarsDao{" +
                "driverId=" + driverId +
                ", driverName='" + driverName + '\'' +
                ", usedCars=" + usedCars +
                '}';
    }
}

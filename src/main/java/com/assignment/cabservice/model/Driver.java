package com.assignment.cabservice.model;

import jakarta.persistence.*;

@Entity
public class Driver {
    @Id
    @GeneratedValue
    private Integer id;
    private String username;
    private String password;
    private Integer assignedCarId;
    private String usedCarIds;

    public Driver() {}
    public Driver(Integer id, String username, Integer assignedCarId, String usedCarIds) {
        this.id = id;
        this.username = username;
        this.assignedCarId = assignedCarId;
        this.usedCarIds = usedCarIds;
    }

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

    public String getUsedCarIds() {
        return usedCarIds;
    }

    public void setUsedCarIds(String usedCarIds) {
        this.usedCarIds = usedCarIds;
    }

    public Integer getAssignedCarId() {
        return assignedCarId;
    }

    public void setAssignedCarId(Integer assignedCarId) {
        this.assignedCarId = assignedCarId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", assignedCarId=" + assignedCarId +
                ", usedCarIds='" + usedCarIds + '\'' +
                '}';
    }
}

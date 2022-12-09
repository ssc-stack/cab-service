package com.assignment.cabservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

//@Entity
public class User {
    @Id
    @GeneratedValue
    private Integer userId;
    private String userName;
    private String password;
    private String provider;
}

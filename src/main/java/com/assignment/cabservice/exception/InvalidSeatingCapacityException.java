package com.assignment.cabservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.BAD_REQUEST)
public class InvalidSeatingCapacityException extends RuntimeException {
    public InvalidSeatingCapacityException(String message) {
        super(message);
    }
}

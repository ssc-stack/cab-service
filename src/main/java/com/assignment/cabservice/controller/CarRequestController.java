package com.assignment.cabservice.controller;

import com.assignment.cabservice.model.Car;
import com.assignment.cabservice.model.CarRequest;
import com.assignment.cabservice.model.Driver;
import com.assignment.cabservice.repository.CarRepository;
import com.assignment.cabservice.repository.CarRequestRepository;
import com.assignment.cabservice.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CarRequestController {

    @Autowired
    CarRepository carRepository;
    @Autowired
    DriverRepository driverRepository;
    @Autowired
    CarRequestRepository carRequestRepository;

    @RequestMapping("approve-request")
    public String approveDriverRequest(@RequestParam int requestId,
                                       @RequestParam int driverId,
                                       @RequestParam int carId) throws Exception {
        Driver driver=driverRepository.findById(driverId).orElseThrow(() ->
                new Exception("Driver not found with driverID - " + driverId));
        driver.setAssignedCarId(carId);
        driver.setUsedCarIds(driver.getUsedCarIds()+","+carId);
        Car car=carRepository.findById(carId).orElseThrow(() ->
                new Exception("Car not found with carID - " + carId));

        CarRequest carRequest=carRequestRepository.findById(requestId).orElseThrow(() ->
                new Exception("Request not found with requestID - " + requestId));
        carRequest.setRequestStatus("APPROVED");
        car.setDriverId(driverId);
        carRequestRepository.save(carRequest);
        carRepository.save(car);
        driverRepository.save(driver);
        return "redirect:/list-car-requests";
    }

    @RequestMapping("reject-request")
    public String rejectDriverRequest(@RequestParam int requestId) throws Exception {
        CarRequest carRequest=carRequestRepository.findById(requestId).orElseThrow(() ->
                new Exception("Request not found with requestID - " + requestId));
        carRequest.setRequestStatus("REJECTED");
        carRequestRepository.save(carRequest);
        return "redirect:/list-car-requests";
    }

    @RequestMapping("delete-car-requests")
    public String rejectDriverRequest()  {
        carRequestRepository.deleteAll();
        return "redirect:/list-car-requests";
    }

    //localhost:8080/list-car-requests/
    @RequestMapping("list-car-requests")
    public String listAllCarRequests(ModelMap modelMap) {
        List<CarRequest> carRequests=carRequestRepository.findAll();
        modelMap.put("car_requests",carRequests);
        return "listCarRequests";
    }

}

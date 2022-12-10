package com.assignment.cabservice.controller;

import com.assignment.cabservice.exception.InvalidSeatingCapacityException;
import com.assignment.cabservice.model.Car;
import com.assignment.cabservice.model.Driver;
import com.assignment.cabservice.repository.CarRepository;
import com.assignment.cabservice.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class CarController {

    @Autowired
    private CarRepository carRepository;
    @Autowired
    private DriverRepository driverRepository;

    @RequestMapping("list-cars")
    public String listAllCars(ModelMap modelMap) {
        List<Car> cars=carRepository.findAll();
        modelMap.put("cars",cars);
        return "listCars";
    }

    @RequestMapping("list-available-cars")
    public String listAllAvailableCarsForBooking(@RequestParam int seatingCapacity,ModelMap modelMap) {
        List<Car> cars=carRepository.findBySeatingCapacityAndAvailableForBookingTrue(seatingCapacity);
        modelMap.put("cars",cars);
        return "listCarsAvailableForBooking";
    }

    @RequestMapping(value="add-car",method= RequestMethod.GET)
    public String showNewCarPage(Car car) {
        return "car";
    }

    //public String addNewTodo(@Valid Todo todo, ModelMap modelMap, BindingResult bindingResult) {
    @RequestMapping(value="add-car",method= RequestMethod.POST)
    public String addNewCar(Car car) throws Exception {
        int capacity=car.getSeatingCapacity();
        if(capacity!=3 && capacity!=4 && capacity!=7) {
            throw  new InvalidSeatingCapacityException("Allowed capacities are: {3,4,7}");
        }

        car.setAvailableForBooking(true);
        carRepository.save(car);
        return "redirect:list-cars";
    }

    //http://localhost:8080/delete-car?id=502
    @RequestMapping(value="delete-car")
    public String deleteCar(@RequestParam int id) {
        carRepository.deleteById(id);
        return "redirect:list-cars";
    }



    //localhost:8080/assign-car/carId/503/driverId/152
    @GetMapping(value="assign-car/carId/{carId}/driverId/{driverId}")
    public String assignDriverToCar(@PathVariable int carId,@PathVariable int driverId) throws Exception {
        Driver driver=driverRepository.findById(driverId).orElseThrow(() ->
                new Exception("Driver not found with driverID - " + driverId));
        int previousAssignedCarId=driver.getAssignedCarId();
        driver.setAssignedCarId(carId);
        driver.setUsedCarIds(driver.getUsedCarIds()+","+carId);
        Car previousAssignedCar=carRepository.findById(previousAssignedCarId).orElseThrow(() ->
                new Exception("Car not found with carID - " + previousAssignedCarId));;
        previousAssignedCar.setDriverId(null);
        Car car=carRepository.findById(carId).orElseThrow(() ->
                new Exception("Car not found with carID - " + carId));;
        car.setDriverId(driverId);
        carRepository.save(previousAssignedCar);
        carRepository.save(car);
        driverRepository.save(driver);
        return "redirect:/list-cars";
    }

    /*@GetMapping(path="/jpa/users/{id}/posts")
    public List<Post> retrievePostsForUser(@PathVariable int id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()) {
            throw new UserNotFoundException("User not found");
        }

        return user.get().getPosts();
    }*/
}

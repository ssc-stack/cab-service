package com.assignment.cabservice.controller;

import com.assignment.cabservice.model.Car;
import com.assignment.cabservice.repository.CarRepository;
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
        return "listCars";
    }

    @RequestMapping(value="add-car",method= RequestMethod.GET)
    public String showNewCarPage(Car car) {
        return "car";
    }

    //public String addNewTodo(@Valid Todo todo, ModelMap modelMap, BindingResult bindingResult) {
    @RequestMapping(value="add-car",method= RequestMethod.POST)
    public String addNewCar(Car car) {
        car.setAvailableForBooking(true);
        carRepository.save(car);
        return "redirect:list-cars";
    }

    @RequestMapping(value="delete-car")
    public String deleteCar(@RequestParam int id) {
        carRepository.deleteById(id);
        return "redirect:list-cars";
    }


    @GetMapping(value="assign-car/carId/{carId}/driverId/{driverId}")
    public String assignDriverToCar(@PathVariable int carId,@PathVariable int driverId) {
        Car car=carRepository.findById(carId).get();
        car.setDriverId(driverId);
        carRepository.save(car);
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

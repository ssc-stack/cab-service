package com.assignment.cabservice.controller;

import com.assignment.cabservice.dao.DriverUseCarsDao;
import com.assignment.cabservice.model.Car;
import com.assignment.cabservice.model.Driver;
import com.assignment.cabservice.repository.CarRepository;
import com.assignment.cabservice.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class DriverController {
    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private CarRepository carRepository;

    @RequestMapping("list-drivers")
    public String listAllDrivers(ModelMap modelMap) {
        List<Driver> drivers=driverRepository.findAll();
        modelMap.put("drivers",drivers);
        return "listDrivers";
    }

    @GetMapping("driver/used-cars")
    @ResponseBody
    public DriverUseCarsDao getCarsUsedByDriver(@RequestParam int driverId) throws Exception {
        Optional<Driver> driverOptional=driverRepository.findById(driverId);
        if(driverOptional.isPresent()) {
            Driver driver=driverOptional.get();
            String[] usedCars=driver.getUsedCarIds().split(",");
            List<Integer> carIds=new ArrayList<>();
            for(String cardId:usedCars) {
                carIds.add(Integer.parseInt(cardId));
            }

            List<Car> carList=carRepository.findByIdIn(carIds);
            DriverUseCarsDao driverUseCarsDao=new DriverUseCarsDao(driverId,driver.getUsername(),carList);

            return driverUseCarsDao;
        }

        throw new Exception("Driver not found");
    }

    @RequestMapping(value="add-driver",method= RequestMethod.GET)
    public String showNewDriverPage(Driver driver) {
        return "driver";
    }

    //public String addNewTodo(@Valid Todo todo, ModelMap modelMap, BindingResult bindingResult) {
    @RequestMapping(value="add-driver",method= RequestMethod.POST)
    public String addNewDriver(Driver driver) {
        driver.setPassword("$2a$12$TLJOLK.QjLRdxOHew1XMT.eYa2Xr5HMHaT14fRoI3gMOIZijNu9F2");//123
        driver.setUsedCarIds(""+driver.getAssignedCarId());
        Driver savedDriver=driverRepository.save(driver);
        Car car=carRepository.findById(driver.getAssignedCarId()).get();
        car.setDriverId(savedDriver.getId());
        carRepository.save(car);
        return "redirect:list-drivers";
    }

    @RequestMapping(value="delete-driver")
    public String deleteDriver(@RequestParam int id) {
        driverRepository.deleteById(id);
        return "redirect:list-drivers";
    }

}

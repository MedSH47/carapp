package com.carapp.carapp.controller;

import com.carapp.carapp.model.Car;
import com.carapp.carapp.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Cars")
public class CarController {

    @Autowired
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/All")
    public List<Car> getCars() {
        return carService.getAllCars();
    }

    @PostMapping("/Create")
    public ResponseEntity<String> createCar(@RequestBody Car car) {
        return carService.createCar(car);
    }

    @PutMapping("/Modify/{id}")
    public ResponseEntity<String> updateCar(@PathVariable String id, @RequestBody Car car) {
        return carService.modifyById(id, car);
    }

    @DeleteMapping("/Delete/{id}")
    public ResponseEntity<String> deleteCar(@PathVariable String id) {
        return carService.deleteCar(id);
    }
}

package com.carapp.carapp.service;

import com.carapp.carapp.model.Car;
import com.carapp.carapp.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CarService {

    @Autowired
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public ResponseEntity<String> createCar(Car car) {
        carRepository.save(car);
        return ResponseEntity.ok("Car created successfully!");
    }

    public ResponseEntity<String> modifyById(String id, Car car) {
        boolean existingCar = carRepository.existsById(id);
        if (existingCar) {
            car.setId(id);
            carRepository.save(car);
            return ResponseEntity.ok("Car with id: " + id + " updated successfully");
        }
        return ResponseEntity.badRequest().body("Car with id: " + id + " not found");
    }

    public ResponseEntity<String> deleteCar(String id) {
        if (carRepository.existsById(id)) {
            carRepository.deleteById(id);
            return ResponseEntity.ok("Car with id: " + id + " deleted successfully");
        }
        return ResponseEntity.badRequest().body("Car with id: " + id + " not found");
    }
}

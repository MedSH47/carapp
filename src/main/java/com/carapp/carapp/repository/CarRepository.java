package com.carapp.carapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.carapp.carapp.model.Car;

@Repository
public interface CarRepository extends MongoRepository<Car,String> {
    
}

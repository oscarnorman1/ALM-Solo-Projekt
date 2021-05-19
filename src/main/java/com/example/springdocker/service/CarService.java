package com.example.springdocker.service;

import com.example.springdocker.model.Car;
import com.example.springdocker.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CarService {

    private final CarRepository carRepository;

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public List<Car> getAllCarsByName(String name) {
        return carRepository.findAllByName(name);
    }

    public List<Car> findAllCarsByYear(String year) {
        return carRepository.findAllByYear(year);
    }

    public Car findCarById(String id) {
        return carRepository.findCarById(id);
    }

    public List<Car> getCarsByColor(String color) {
        return carRepository.findCarByColor(color);
    }

    public Car saveNewCar(Car car) {
        return carRepository.save(car);
    }
}

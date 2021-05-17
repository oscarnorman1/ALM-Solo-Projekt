package com.example.springdocker.controller;

import com.example.springdocker.model.Car;
import com.example.springdocker.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CarController {

    private final CarService carService;

    @GetMapping("/allCars")
    public List<Car> getCars() {
        return carService.getAllCars();
    }

    @GetMapping("/carsByColor")
    public List<Car> carsByColor(@RequestParam String color) {
        return carService.getCarsByColor(color);
    }

    @PostMapping("/addCar")
    public void addCar(@RequestBody Car car) {
        carService.saveNewCar(car);
    }

}

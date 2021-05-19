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

    @GetMapping("/")
    public String Welcome() {
        return "Hello!";
    }

    @GetMapping("/allCars")
    public List<Car> getCars() {
        return carService.getAllCars();
    }

    @GetMapping("/carsByColor")
    public List<Car> carsByColor(@RequestParam String color) {
        return carService.getCarsByColor(color);
    }

    @PostMapping("/addCar")
    public Car addCar(@RequestBody Car car) {
        return carService.saveNewCar(car);
    }

    @GetMapping("/findCarsByName")
    public List<Car> findCarsByName(@RequestParam String name) {
        return carService.getAllCarsByName(name);
    }

    @GetMapping("/findCarById")
    public Car findCarById(@RequestParam String id) {
        return carService.findCarById(id);
    }

    @GetMapping("/findAllCarsByYear")
    public List<Car> findCarsByYear(@RequestParam String year) {
        return carService.findAllCarsByYear(year);
    }

}

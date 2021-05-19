package com.example.springdocker.service;

import com.example.springdocker.model.Car;
import com.example.springdocker.repository.CarRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CarServiceTest {

    CarService carService;

    @Mock
    CarRepository mockRepository;

    @BeforeEach
    void init() {
        carService = new CarService(mockRepository);
    }

    @AfterEach
    void clearDb() {
        mockRepository.deleteAll();
    }

    @Test
    void getAllCarsTest() {
        carService.getAllCars();

        verify(mockRepository).findAll();
    }

    @Test
    void getAllCarsByNameTest() {

    }

    @Test
    void findAllCarsByYearTest() {
    }

    @Test
    void findCarByIdTest() {
    }

    @Test
    void getCarsByColorTest() {
        List<Car> mockList = Arrays.asList(
                new Car("2", "Audi", "2001", "Black")
        );

        List<Car> expected = Arrays.asList(new Car("2", "Audi", "2001", "Black"));

        when(mockRepository.findAllByColor("Black")).thenReturn(mockList);

        List<Car> actual = carService.getCarsByColor("Black");

        assertEquals(expected, actual);

    }

    @Test
    void saveNewCarTest() {
        String expectedId = "123";
        String expectedName = "Volvo";
        String expectedYear = "2010";
        String expectedColor = "Black";

        Car car = new Car(expectedId, expectedName, expectedYear, expectedColor);

        when(mockRepository.save(isA(Car.class))).thenReturn(new Car(expectedId, expectedName, expectedYear, expectedColor));

        //Testing methods
        Car actual = carService.saveNewCar(car);

        verify(mockRepository).save(isA(Car.class));

        assertEquals(expectedId, actual.getId());
        assertEquals(expectedName, actual.getName());
        assertEquals(expectedYear, actual.getYear());
        assertEquals(expectedColor, actual.getColor());
    }
}
package com.example.springdocker.repository;

import com.example.springdocker.model.Car;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
class CarRepositoryTest {

    @Autowired
    CarRepository carRepository;

    @BeforeEach
    void init() {
        carRepository.save(new Car("1", "Volvo", "2005", "Yellow"));
        carRepository.save(new Car("2", "Audi", "2018", "Red"));
        carRepository.save(new Car("3", "Ford", "2015", "Blue"));
    }

    @AfterEach
    void clearDb() {
        carRepository.deleteAll();
    }

    @Test
    void findCarByColorTest() {
        Car expected = carRepository.findCarByColor("Yellow").get(0);
        Car unExpected = carRepository.findCarByColor("Red").get(0);

        assertEquals(expected.getColor(), "Yellow");
        assertNotEquals(expected.getColor(), unExpected.getColor());
    }

}
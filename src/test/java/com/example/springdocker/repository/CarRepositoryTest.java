package com.example.springdocker.repository;

import com.example.springdocker.model.Car;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.web.util.ContentCachingRequestWrapper;

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
        carRepository.save(new Car("4", "Volvo", "2019", "Black"));
        carRepository.save(new Car("5", "Ferrari", "2019", "Red"));
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

    @Test
    void findAllByName() {
        List<Car> expected = carRepository.findAllByName("Volvo");
        List<Car> unExpected = carRepository.findAllByName("Audi");

        assertEquals(expected.get(0).getName(), "Volvo");
        assertEquals(expected.get(1).getName(), "Volvo");
        assertNotEquals(expected.get(0).getName(), unExpected.get(0).getName());
    }

    @Test
    void findCarByIdTest() {
        Car expected = carRepository.findCarById("1");
        Car unExpected = carRepository.findCarById("2");

        assertEquals(expected.getId(), "1");
        assertNotEquals(expected, unExpected);
    }

    @Test
    void findAllByYearTest() {
        List<Car> expected = carRepository.findAllByYear("2019");
        String unExpected = "2010";

        assertEquals(expected.get(0).getYear(), "2019");
        assertEquals(expected.get(1).getYear(), "2019");

        assertNotEquals(expected.get(0).getYear(), unExpected);
        assertNotEquals(expected.get(0).getYear(), "2021");
    }

}
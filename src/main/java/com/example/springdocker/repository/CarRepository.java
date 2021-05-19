package com.example.springdocker.repository;

import com.example.springdocker.model.Car;
import com.example.springdocker.model.Food;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CarRepository extends MongoRepository<Car, String> {

    List<Car> findAllByColor(String color);
    List<Car> findAllByName(String name);
    Car findCarById(String id);
    List<Car> findAllByYear(String year);
}

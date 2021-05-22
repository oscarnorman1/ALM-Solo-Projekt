package com.example.springdocker.service;

import com.example.springdocker.model.Car;
import com.example.springdocker.model.Food;
import com.example.springdocker.repository.FoodRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DataMongoTest
public class FoodServiceTest {

    FoodService foodService;

    @Mock
    FoodRepository mockRepository;

    @BeforeEach
    void init() {
        foodService = new FoodService(mockRepository);
    }

    @Test
    void getFoodsTest() {
        foodService.getFoods();

        verify(mockRepository).findAll();
    }

    @Test
    void saveNewFoodTest() {
        String expectedId = "123";
        String expectedName = "Pasta";
        boolean expectedDelicious = true;
        boolean expectedCanICookIt = true;

        Food food = new Food(expectedId, expectedName, expectedDelicious, expectedCanICookIt);

        when(mockRepository.save(isA(Food.class))).thenReturn(food);

        //Testing methods
        foodService.saveNewFood(food);

        verify(mockRepository).save(isA(Food.class));
    }

    @Test
    void getCookableFoodsTest() {
        List<Food> mockList = Arrays.asList(
                new Food("1", "Pasta", true, true)
        );

        List<Food> expected = Arrays.asList(new Food("1", "Pasta", true, true));

        when(mockRepository.findFoodByCanICookIt(true)).thenReturn(mockList);

        List<String> actual = foodService.getCookableFoods();

        assertEquals(expected.get(0).getName(), actual.get(0));
    }

}

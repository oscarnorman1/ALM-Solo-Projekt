package com.example.springdocker.repository;


import com.example.springdocker.model.Food;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import com.example.springdocker.repository.FoodRepository;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
class FoodRepositoryTest {

    @Autowired
    FoodRepository foodRepository;

    @BeforeEach
    void init() {
        foodRepository.save(new Food("1", "Fisksoppa toppad med räkor", true, true));
        foodRepository.save(new Food("2", "Whiskykyckling med klyftpotatis", true, true));
        foodRepository.save(new Food("3", "Falsk fläskfilé i gräddsås", false, false));
    }

    @AfterEach
    void clearDb() {
        foodRepository.deleteAll();
    }

    @Test
    void findFoodByCanICookIt() {
        boolean expected = foodRepository.findFoodByCanICookIt(true).get(0).isCanICookIt();
        boolean unExpected = foodRepository.findFoodByCanICookIt(false).get(0).isCanICookIt();

        assertTrue(expected);
        assertFalse(unExpected);

    }

}
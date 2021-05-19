package com.example.springdocker.MyMathCalcTest;

import com.example.springdocker.MyMathCalc.MyMathCalc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyMathCalcTest {

    MyMathCalc calc;

    @BeforeEach
    public void init() {
        calc = new MyMathCalc();
    }

    @Test
    void addTest() {
        int expected = calc.add(10, 10);
        int unExpected = 11;

        assertEquals(expected, 20);
        assertNotEquals(expected, unExpected);
    }

    @Test
    void multiplyTest() {
        int expected = calc.multiply(5, 5);
        int unExpected = 20;

        assertEquals(expected, 25);
        assertNotEquals(expected, unExpected);

    }

    @Test
    void divideTest() {
        double expected = calc.divide(10, 2);
        double unExpected = 4.0;

        assertEquals(expected, 5);
        assertNotEquals(expected, unExpected);
    }

    @Test
    void divideThrowTest() {
        assertThrows(ArithmeticException.class, () -> calc.divide(0, 5));
    }
}






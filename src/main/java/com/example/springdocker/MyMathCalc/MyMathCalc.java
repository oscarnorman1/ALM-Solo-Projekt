package com.example.springdocker.MyMathCalc;

public class MyMathCalc {

    public int add(int a, int b) {
        return a + b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if(a == 0 || b == 0)
            throw new ArithmeticException("Du få ej dela med 0");
        return a / b;
    }
}
